package svalbuena.springframework.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import svalbuena.springframework.sfgpetclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {}
