package svalbuena.springframework.sfgpetclinic.services.map;

import org.springframework.stereotype.Service;
import svalbuena.springframework.sfgpetclinic.model.Pet;
import svalbuena.springframework.sfgpetclinic.model.PetType;
import svalbuena.springframework.sfgpetclinic.services.PetService;
import svalbuena.springframework.sfgpetclinic.services.PetTypeService;

@Service
public class PetMapService extends AbstractMapService<Pet, Long> implements PetService {
    final PetTypeService petTypeService;

    public PetMapService(final PetTypeService petTypeService) {
        this.petTypeService = petTypeService;
    }

    @Override
    public Pet save(final Pet pet) {
        final PetType petType = pet.getPetType();
        if (petType.doesNotHaveId()) {
            petTypeService.save(petType);
        }
        return super.save(pet);
    }
}
