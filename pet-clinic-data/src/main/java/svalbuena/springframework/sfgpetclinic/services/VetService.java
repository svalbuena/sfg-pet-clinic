package svalbuena.springframework.sfgpetclinic.services;

import svalbuena.springframework.sfgpetclinic.model.Vet;

import java.util.Set;

public interface VetService {
    Vet findById(final Long id);
    Set<Vet> findAll();
    Vet save(final Vet vet);
}
