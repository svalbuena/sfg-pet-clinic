package svalbuena.springframework.sfgpetclinic.services;

import svalbuena.springframework.sfgpetclinic.model.Visit;

import java.time.LocalDate;

public abstract class AbstractVisitServiceTest extends AbstractServiceTest<Visit, VisitService> {
    @Override
    protected Visit givenObject() {
        return givenVisit();
    }

    private Visit givenVisit() {
        final Visit visit = new Visit();
        visit.setDescription("VISIT");
        visit.setDate(LocalDate.EPOCH);
        return visit;
    }
}