package svalbuena.springframework.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import svalbuena.springframework.sfgpetclinic.model.Owner;

import java.util.Optional;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
    Owner findByLastName(final String lastName);
}
