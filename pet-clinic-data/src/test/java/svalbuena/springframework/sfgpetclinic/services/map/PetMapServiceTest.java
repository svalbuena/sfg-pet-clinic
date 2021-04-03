package svalbuena.springframework.sfgpetclinic.services.map;

import svalbuena.springframework.sfgpetclinic.services.PetService;
import svalbuena.springframework.sfgpetclinic.services.AbstractPetServiceTest;

public class PetMapServiceTest extends AbstractPetServiceTest {
    @Override
    protected PetService givenServiceImplementation() {
        return new PetMapService();
    }
}
