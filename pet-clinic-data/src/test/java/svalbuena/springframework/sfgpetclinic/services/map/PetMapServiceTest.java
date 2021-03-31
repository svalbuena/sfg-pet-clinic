package svalbuena.springframework.sfgpetclinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import svalbuena.springframework.sfgpetclinic.model.Owner;
import svalbuena.springframework.sfgpetclinic.model.Pet;
import svalbuena.springframework.sfgpetclinic.model.PetType;

import java.time.LocalDate;

class PetMapServiceTest extends AbstractMapServiceTest<Pet, Long> {
    private Long nextId;

    @BeforeEach
    void setUp() {
        nextId = 0L;
        service = new PetMapService();
    }

    @Override
    Pet givenObject() {
        return givenPet();
    }

    @Override
    Long getObjectId(final Pet pet) {
        return pet.getId();
    }

    private Pet givenPet() {
        final Long id = getNextId();
        final Pet pet = new Pet();
        pet.setId(id);
        pet.setBirthDate(LocalDate.EPOCH);
        pet.setOwner(givenOwner());
        pet.setType(givenPetType(id));
        return pet;
    }

    private Owner givenOwner() {
        final Owner owner = new Owner();
        owner.setId(0L);
        owner.setFirstName("FIRST_NAME");
        owner.setLastName("LAST_NAME");
        return owner;
    }

    private PetType givenPetType(final Long id) {
        final PetType type = new PetType();
        type.setName("PET_TYPE_" + id);
        return type;
    }

    private Long getNextId() {
        final Long id = nextId;
        nextId += 1L;
        return id;
    }
}