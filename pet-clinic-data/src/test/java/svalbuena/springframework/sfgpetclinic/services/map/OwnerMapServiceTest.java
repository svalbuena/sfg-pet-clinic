package svalbuena.springframework.sfgpetclinic.services.map;

import svalbuena.springframework.sfgpetclinic.services.OwnerService;
import svalbuena.springframework.sfgpetclinic.services.AbstractOwnerServiceTest;

public class OwnerMapServiceTest extends AbstractOwnerServiceTest {
    @Override
    protected OwnerService givenServiceImplementation() {
        return new OwnerMapService(new PetMapService(new PetTypeMapService()));
    }
}
