package svalbuena.springframework.sfgpetclinic.services.map;

import org.springframework.stereotype.Service;
import svalbuena.springframework.sfgpetclinic.model.BaseEntity;
import svalbuena.springframework.sfgpetclinic.model.Vet;
import svalbuena.springframework.sfgpetclinic.services.VetService;

@Service
public class VetMapService extends AbstractMapService<Vet> implements VetService {
    private final SpecialtyMapService specialtyMapService;

    public VetMapService() {
        this.specialtyMapService = new SpecialtyMapService();
    }

    @Override
    public Vet save(final Vet vet) {
        vet.getSpecialties().stream()
                .filter(BaseEntity::doesNotHaveId)
                .forEach(specialtyMapService::save);
        return super.save(vet);
    }
}
