package svalbuena.springframework.sfgpetclinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import svalbuena.springframework.sfgpetclinic.model.Owner;
import svalbuena.springframework.sfgpetclinic.model.Pet;
import svalbuena.springframework.sfgpetclinic.model.PetType;

import java.time.LocalDate;

class PetMapServiceTest extends AbstractMapServiceTest<Pet> {
    @BeforeEach
    void setUp() {
        service = new PetMapService(new PetTypeMapService());
    }

    @Override
    Pet givenObject() {
        return givenPet();
    }

    private Pet givenPet() {
        final Pet pet = new Pet();
        pet.setBirthDate(LocalDate.EPOCH);
        pet.setOwner(givenOwner());
        pet.setType(givenPetType());
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