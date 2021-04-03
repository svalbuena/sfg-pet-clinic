package svalbuena.springframework.sfgpetclinic.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import svalbuena.springframework.sfgpetclinic.model.Owner;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class AbstractOwnerServiceTest extends AbstractServiceTest<Owner, OwnerService> {
    @Override
    protected Owner givenObject() {
        return givenOwner();
    }

    @Test
    void testFindByLastName() {
        final Owner owner = givenOwner();

        service.save(owner);
        final Owner actualOwner = service.findByLastName(owner.getLastName());

        assertThat(actualOwner).isEqualTo(owner);
    }

    private Owner givenOwner() {
        final Owner owner = new Owner();
        owner.setFirstName("FIRST_NAME");
        owner.setLastName("LAST_NAME");
        return owner;
    }
}