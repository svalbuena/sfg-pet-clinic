package svalbuena.springframework.sfgpetclinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import svalbuena.springframework.sfgpetclinic.model.BaseEntity;
import svalbuena.springframework.sfgpetclinic.model.Owner;
import svalbuena.springframework.sfgpetclinic.services.OwnerService;

@Profile({"default", "map"})
@Service
public class OwnerMapService extends AbstractMapService<Owner> implements OwnerService {
    private final PetMapService petMapService;

    public OwnerMapService() {
        this.petMapService = new PetMapService();
    }

    @Override
    public Owner save(final Owner owner) {
        owner.getPets().stream()
                .filter(BaseEntity::doesNotHaveId)
                .forEach(petMapService::save);
        return super.save(owner);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return map.values().stream()
                .filter(owner -> lastName.equals(owner.getLastName()))
                .findFirst()
                .orElse(null);
    }
}
