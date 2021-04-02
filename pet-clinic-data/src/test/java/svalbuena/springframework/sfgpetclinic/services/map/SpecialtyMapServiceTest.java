package svalbuena.springframework.sfgpetclinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import svalbuena.springframework.sfgpetclinic.model.Specialty;

class SpecialtyMapServiceTest extends AbstractMapServiceTest<Specialty> {
    @BeforeEach
    void setUp() {
        service = new SpecialtyMapService();
    }

    @Override
    Specialty givenObject() {
        return givenSpeciality();
    }

    private Specialty givenSpeciality() {
        final Specialty specialty = new Specialty();
        specialty.setDescription("SPECIALITY_DESCRIPTION");
        return specialty;
    }
}