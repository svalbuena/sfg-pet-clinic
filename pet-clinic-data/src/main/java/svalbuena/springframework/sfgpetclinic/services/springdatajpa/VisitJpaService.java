package svalbuena.springframework.sfgpetclinic.services.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import svalbuena.springframework.sfgpetclinic.model.Visit;
import svalbuena.springframework.sfgpetclinic.repositories.VisitRepository;
import svalbuena.springframework.sfgpetclinic.services.VisitService;

@Profile("springdatajpa")
@Service
public class VisitJpaService extends AbstractJpaService<Visit, VisitRepository> implements VisitService {
    public VisitJpaService(final VisitRepository repository) {
        super(repository);
    }
}
