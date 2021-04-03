package svalbuena.springframework.sfgpetclinic.services.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import svalbuena.springframework.sfgpetclinic.model.PetType;
import svalbuena.springframework.sfgpetclinic.repositories.PetTypeRepository;
import svalbuena.springframework.sfgpetclinic.services.PetTypeService;

@Profile("springdatajpa")
@Service
public class PetTypeJpaService extends AbstractJpaService<PetType, PetTypeRepository> implements PetTypeService {
    public PetTypeJpaService(final PetTypeRepository repository) {
        super(repository);
    }
}
