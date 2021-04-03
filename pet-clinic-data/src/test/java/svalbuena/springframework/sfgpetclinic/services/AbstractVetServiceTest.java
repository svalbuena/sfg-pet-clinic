package svalbuena.springframework.sfgpetclinic.services;

import svalbuena.springframework.sfgpetclinic.model.Vet;

public abstract class AbstractVetServiceTest extends AbstractServiceTest<Vet, VetService> {
    @Override
    protected Vet givenObject() {
        return givenVet();
    }

    private Vet givenVet() {
        final Vet vet = new Vet();
        vet.setFirstName("FIRST_NAME");
        vet.setLastName("LAST_NAME");
        return vet;
    }
}