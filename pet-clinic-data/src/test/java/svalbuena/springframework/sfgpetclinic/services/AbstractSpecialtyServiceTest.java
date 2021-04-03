package svalbuena.springframework.sfgpetclinic.services;

import svalbuena.springframework.sfgpetclinic.model.Specialty;

public abstract class AbstractSpecialtyServiceTest extends AbstractServiceTest<Specialty, SpecialtyService> {
    @Override
    protected Specialty givenObject() {
        return givenSpeciality();
    }

    private Specialty givenSpeciality() {
        final Specialty specialty = new Specialty();
        specialty.setDescription("SPECIALITY_DESCRIPTION");
        return specialty;
    }
}