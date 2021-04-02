package svalbuena.springframework.sfgpetclinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import svalbuena.springframework.sfgpetclinic.model.PetType;

class PetTypeMapServiceTest extends AbstractMapServiceTest<PetType> {
    @BeforeEach
    void setUp() {
        service = new PetTypeMapService();
    }

    @Override
    PetType givenObject() {
        return givenPetType();
    }

    private PetType givenPetType() {
        final PetType petType = new PetType();
        petType.setName("PET_TYPE");
        return petType;
    }
}