package svalbuena.springframework.sfgpetclinic.services.map;

import svalbuena.springframework.sfgpetclinic.services.PetTypeService;
import svalbuena.springframework.sfgpetclinic.services.AbstractPetTypeServiceTest;

public class PetTypeMapServiceTest extends AbstractPetTypeServiceTest {
    @Override
    protected PetTypeService givenServiceImplementation() {
        return new PetTypeMapService();
    }
}
