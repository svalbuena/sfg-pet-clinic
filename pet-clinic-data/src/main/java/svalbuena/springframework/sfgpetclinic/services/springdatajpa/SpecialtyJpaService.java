package svalbuena.springframework.sfgpetclinic.services.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import svalbuena.springframework.sfgpetclinic.model.Specialty;
import svalbuena.springframework.sfgpetclinic.repositories.SpecialtyRepository;
import svalbuena.springframework.sfgpetclinic.services.SpecialtyService;

@Profile("springdatajpa")
@Service
public class SpecialtyJpaService extends AbstractJpaService<Specialty, SpecialtyRepository> implements SpecialtyService {
    public SpecialtyJpaService(final SpecialtyRepository repository) {
        super(repository);
    }
}
