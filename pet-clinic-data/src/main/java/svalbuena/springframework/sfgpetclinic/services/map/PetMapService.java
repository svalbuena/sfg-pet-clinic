package svalbuena.springframework.sfgpetclinic.services.map;

import svalbuena.springframework.sfgpetclinic.model.Pet;
import svalbuena.springframework.sfgpetclinic.services.PetService;

public class PetMapService extends AbstractMapService<Pet, Long> implements PetService {
    @Override
    public Pet save(final Pet pet) {
        map.put(pet.getId(), pet);
        return pet;
    }
}
