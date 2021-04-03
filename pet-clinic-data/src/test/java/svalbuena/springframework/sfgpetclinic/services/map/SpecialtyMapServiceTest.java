package svalbuena.springframework.sfgpetclinic.services.map;

import svalbuena.springframework.sfgpetclinic.services.SpecialtyService;
import svalbuena.springframework.sfgpetclinic.services.AbstractSpecialtyServiceTest;

public class SpecialtyMapServiceTest extends AbstractSpecialtyServiceTest {
    @Override
    protected SpecialtyService givenServiceImplementation() {
        return new SpecialtyMapService();
    }
}
