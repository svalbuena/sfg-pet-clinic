package svalbuena.springframework.sfgpetclinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import svalbuena.springframework.sfgpetclinic.model.Owner;
import svalbuena.springframework.sfgpetclinic.services.OwnerService;

import static org.assertj.core.api.Assertions.assertThat;

class OwnerMapServiceTest extends AbstractMapServiceTest<Owner, Long> {
    private OwnerService ownerService;
    private Long nextId;

    @BeforeEach
    void setUp() {
        nextId = 0L;
        ownerService = new OwnerMapService();
        service = ownerService;
    }

    @Override
    Owner givenObject() {
        return givenOwner();
    }

    @Override
    Long getObjectId(final Owner owner) {
        return owner.getId();
    }

    @Test
    void testFindByLastName() {
        final Owner owner = givenOwner();

        service.save(owner);
        final Owner actualOwner = ownerService.findByLastName(owner.getLastName());

        assertThat(actualOwner).isEqualTo(owner);
    }

    private Owner givenOwner() {
        final Long id = getNextId();
        final Owner owner = new Owner();
        owner.setId(id);
        owner.setFirstName("FIRST_NAME_" + id);
        owner.setLastName("LAST_NAME_" + id);
        return owner;
    }

    private Long getNextId() {
        final Long id = nextId;
        nextId += 1L;
        return id;
    }
}