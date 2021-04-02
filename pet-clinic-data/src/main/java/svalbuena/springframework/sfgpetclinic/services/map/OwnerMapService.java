package svalbuena.springframework.sfgpetclinic.services.map;

import org.springframework.stereotype.Service;
import svalbuena.springframework.sfgpetclinic.model.Owner;
import svalbuena.springframework.sfgpetclinic.services.OwnerService;
import svalbuena.springframework.sfgpetclinic.services.PetService;

@Service
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {
    private final PetService petService;

    public OwnerMapService(final PetService petService) {
        this.petService = petService;
    }

    @Override
    public Owner save(final Owner owner) {
        owner.getPets().forEach(petService::save);
        return super.save(owner);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return map.values().stream()
                .filter(owner -> lastName.equals(owner.getLastName()))
                .findFirst()
                .orElse(null);
    }
}
