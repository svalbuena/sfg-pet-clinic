package svalbuena.springframework.sfgpetclinic.services;

import org.springframework.stereotype.Service;
import svalbuena.springframework.sfgpetclinic.model.Vet;

@Service
public interface VetService extends CrudService<Vet, Long> {}
