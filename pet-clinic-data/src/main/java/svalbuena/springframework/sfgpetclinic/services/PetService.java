package svalbuena.springframework.sfgpetclinic.services;

import svalbuena.springframework.sfgpetclinic.model.Pet;

import java.util.Set;

public interface PetService {
    Pet findById(final Long id);
    Set<Pet> findAll();
    Pet save(final Pet pet);
}
