package svalbuena.springframework.sfgpetclinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import svalbuena.springframework.sfgpetclinic.model.Vet;

class VetMapServiceTest extends AbstractMapServiceTest<Vet, Long> {
    private Long nextId;

    @BeforeEach
    void setUp() {
        nextId = 0L;
        service = new VetMapService();
    }

    @Override
    Vet givenObject() {
        return givenVet();
    }

    @Override
    Long getObjectId(final Vet vet) {
        return vet.getId();
    }

    private Vet givenVet() {
        final Long id = getNextId();
        final Vet vet = new Vet();
        vet.setId(id);
        vet.setFirstName("FIRST_NAME_" + id);
        vet.setLastName("LAST_NAME" + id);
        return vet;
    }

    private Long getNextId() {
        final Long id = nextId;
        nextId += 1L;
        return id;
    }
}