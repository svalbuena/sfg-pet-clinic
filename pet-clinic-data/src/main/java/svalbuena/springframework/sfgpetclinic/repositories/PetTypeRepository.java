package svalbuena.springframework.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import svalbuena.springframework.sfgpetclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {}
