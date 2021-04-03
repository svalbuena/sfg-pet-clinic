package svalbuena.springframework.sfgpetclinic.services;

import svalbuena.springframework.sfgpetclinic.model.PetType;

public abstract class AbstractPetTypeServiceTest extends AbstractServiceTest<PetType, PetTypeService> {
    @Override
    protected PetType givenObject() {
        return givenPetType();
    }

    private PetType givenPetType() {
        final PetType petType = new PetType();
        petType.setName("PET_TYPE");
        return petType;
    }
}