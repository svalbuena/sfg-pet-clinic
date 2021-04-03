package svalbuena.springframework.sfgpetclinic.services.map;

import svalbuena.springframework.sfgpetclinic.services.VetService;
import svalbuena.springframework.sfgpetclinic.services.AbstractVetServiceTest;

public class VetMapServiceTest extends AbstractVetServiceTest {
    @Override
    protected VetService givenServiceImplementation() {
        return new VetMapService();
    }
}
