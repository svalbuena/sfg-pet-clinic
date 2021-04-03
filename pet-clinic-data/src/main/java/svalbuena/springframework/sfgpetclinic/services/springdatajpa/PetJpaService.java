package svalbuena.springframework.sfgpetclinic.services.springdatajpa;

import svalbuena.springframework.sfgpetclinic.model.Pet;
import svalbuena.springframework.sfgpetclinic.repositories.PetRepository;
import svalbuena.springframework.sfgpetclinic.services.PetService;

public class PetJpaService extends AbstractJpaService<Pet, PetRepository> implements PetService {
    public PetJpaService(final PetRepository repository) {
        super(repository);
    }
}
