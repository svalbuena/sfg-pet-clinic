package svalbuena.springframework.sfgpetclinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import svalbuena.springframework.sfgpetclinic.model.Owner;
import svalbuena.springframework.sfgpetclinic.services.OwnerService;

import static org.assertj.core.api.Assertions.assertThat;

class OwnerMapServiceTest extends AbstractMapServiceTest<Owner> {
    private OwnerService ownerService;

    @BeforeEach
    void setUp() {
        ownerService = new OwnerMapService();
        service = ownerService;
    }

    @Override
    Owner givenObject() {
        return givenOwner();
    }

    @Test
    void testFindByLastName() {
        final Owner owner = givenOwner();

        service.save(owner);
        final Owner actualOwner = ownerService.findByLastName(owner.getLastName());

        assertThat(actualOwner).isEqualTo(owner);
    }

    private Owner givenOwner() {
        final Owner owner = new Owner();
        owner.setFirstName("FIRST_NAME");
        owner.setLastName("LAST_NAME");
        return owner;
    }
}