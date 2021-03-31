package svalbuena.springframework.sfgpetclinic.services;

import svalbuena.springframework.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(final String lastName);
}
