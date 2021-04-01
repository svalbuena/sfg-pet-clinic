package svalbuena.springframework.sfgpetclinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import svalbuena.springframework.sfgpetclinic.model.Vet;

class VetMapServiceTest extends AbstractMapServiceTest<Vet> {
    @BeforeEach
    void setUp() {
        service = new VetMapService();
    }

    @Override
    Vet givenObject() {
        return givenVet();
    }

    private Vet givenVet() {
        final Vet vet = new Vet();
        vet.setFirstName("FIRST_NAME");
        vet.setLastName("LAST_NAME");
        return vet;
    }
}