package svalbuena.springframework.sfgpetclinic.services;

import svalbuena.springframework.sfgpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService {
    Owner findById(final Long id);
    Owner findByLastName(final String lastName);
    Set<Owner> findAll();
    Owner save(final Owner owner);
}
