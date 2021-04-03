package svalbuena.springframework.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import svalbuena.springframework.sfgpetclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {}
