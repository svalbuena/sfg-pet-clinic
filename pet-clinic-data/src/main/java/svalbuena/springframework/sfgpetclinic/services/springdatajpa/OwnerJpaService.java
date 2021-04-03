package svalbuena.springframework.sfgpetclinic.services.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import svalbuena.springframework.sfgpetclinic.model.Owner;

import svalbuena.springframework.sfgpetclinic.repositories.OwnerRepository;
import svalbuena.springframework.sfgpetclinic.services.OwnerService;

@Profile("springdatajpa")
@Service
public class OwnerJpaService extends AbstractJpaService<Owner, Long, OwnerRepository> implements OwnerService {
    private final OwnerRepository ownerRepository;

    public OwnerJpaService(final OwnerRepository ownerRepository) {
        super(ownerRepository);
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Owner findByLastName(final String lastName) {
        return ownerRepository.findByLastName(lastName);
    }
}
