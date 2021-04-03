package svalbuena.springframework.sfgpetclinic.services.map;

import svalbuena.springframework.sfgpetclinic.services.AbstractVisitServiceTest;

public class VisitMapServiceTest extends AbstractVisitServiceTest {
    @Override
    protected VisitMapService givenServiceImplementation() {
        return new VisitMapService();
    }
}
