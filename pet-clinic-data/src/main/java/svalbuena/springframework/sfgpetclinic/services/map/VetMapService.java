package svalbuena.springframework.sfgpetclinic.services.map;

import svalbuena.springframework.sfgpetclinic.model.Vet;
import svalbuena.springframework.sfgpetclinic.services.VetService;

public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {
    @Override
    public Vet save(final Vet vet) {
        map.put(vet.getId(), vet);
        return vet;
    }
}
