package svalbuena.springframework.sfgpetclinic.services.map;

import org.springframework.stereotype.Service;
import svalbuena.springframework.sfgpetclinic.model.BaseEntity;
import svalbuena.springframework.sfgpetclinic.model.Pet;
import svalbuena.springframework.sfgpetclinic.model.PetType;
import svalbuena.springframework.sfgpetclinic.services.PetService;

@Service
public class PetMapService extends AbstractMapService<Pet> implements PetService {
    private final PetTypeMapService petTypeMapService;
    private final VisitMapService visitMapService;

    public PetMapService() {
        this.petTypeMapService = new PetTypeMapService();
        this.visitMapService = new VisitMapService();
    }

    @Override
    public Pet save(final Pet pet) {
        final PetType petType = pet.getPetType();
        if (petType.doesNotHaveId()) {
            petTypeMapService.save(petType);
        }
        pet.getVisits().stream()
                .filter(BaseEntity::doesNotHaveId)
                .forEach(visitMapService::save);
        return super.save(pet);
    }
}
