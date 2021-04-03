package svalbuena.springframework.sfgpetclinic.services.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import svalbuena.springframework.sfgpetclinic.model.Vet;
import svalbuena.springframework.sfgpetclinic.repositories.VetRepository;
import svalbuena.springframework.sfgpetclinic.services.VetService;

@Profile("springdatajpa")
@Service
public class VetJpaService extends AbstractJpaService<Vet, Long, VetRepository> implements VetService {
    public VetJpaService(VetRepository repository) {
        super(repository);
    }
}
