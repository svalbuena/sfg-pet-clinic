package svalbuena.springframework.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import svalbuena.springframework.sfgpetclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {}
