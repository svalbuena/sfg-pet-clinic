package svalbuena.springframework.sfgpetclinic.services;

import svalbuena.springframework.sfgpetclinic.model.Owner;
import svalbuena.springframework.sfgpetclinic.model.Pet;
import svalbuena.springframework.sfgpetclinic.model.PetType;

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
        pet.setPetType(givenPetType());
        pet.setOwner(givenOwner());
        return pet;
    }

    private Owner givenOwner() {
        final Owner owner = new Owner();
        owner.setId(0L);
        owner.setFirstName("FIRST_NAME");
        owner.setLastName("LAST_NAME");
        return owner;
    }

    private PetType givenPetType() {
        final PetType type = new PetType();
        type.setName("PET_TYPE");
        return type;
    }
}