package svalbuena.springframework.sfgpetclinic.services.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import svalbuena.springframework.sfgpetclinic.model.Owner;
import svalbuena.springframework.sfgpetclinic.repositories.OwnerRepository;
import svalbuena.springframework.sfgpetclinic.services.OwnerService;

@Profile("springdatajpa")
@Service
public class OwnerJpaService extends AbstractJpaService<Owner, OwnerRepository> implements OwnerService {
    public OwnerJpaService(final OwnerRepository repository) {
        super(repository);
    }

    @Override
    public Owner findByLastName(final String lastName) {
        return repository.findByLastName(lastName);
    }
}
