package svalbuena.springframework.sfgpetclinic.services;

import svalbuena.springframework.sfgpetclinic.model.Pet;

import java.time.LocalDate;

public abstract class AbstractPetServiceTest extends AbstractServiceTest<Pet, PetService> {
    @Override
    protected Pet givenObject() {
        return givenPet();
    }

    private Pet givenPet() {
        final Pet pet = new Pet();
        pet.setName("NAME");
        pet.setBirthDate(LocalDate.EPOCH);
        return pet;
    }
}