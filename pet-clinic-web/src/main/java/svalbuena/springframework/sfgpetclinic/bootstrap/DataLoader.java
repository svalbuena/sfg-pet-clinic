package svalbuena.springframework.sfgpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import svalbuena.springframework.sfgpetclinic.model.Owner;
import svalbuena.springframework.sfgpetclinic.model.Vet;
import svalbuena.springframework.sfgpetclinic.services.OwnerService;
import svalbuena.springframework.sfgpetclinic.services.VetService;
import svalbuena.springframework.sfgpetclinic.services.map.OwnerMapService;
import svalbuena.springframework.sfgpetclinic.services.map.VetMapService;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        this.ownerService = new OwnerMapService();
        this.vetService = new VetMapService();
    }

    @Override
    public void run(final String... args) throws Exception {
        final Owner owner1 = createOwner(1L);
        ownerService.save(owner1);
        final Owner owner2 = createOwner(2L);
        ownerService.save(owner2);

        final Vet vet1 = createVet(1L);
        vetService.save(vet1);
        final Vet vet2 = createVet(2L);
        vetService.save(vet2);

        System.out.println("Loaded!!");
    }

    private Owner createOwner(final Long id) {
        final Owner owner = new Owner();
        owner.setId(id);
        owner.setFirstName("OWNER_FIRST_NAME_" + id);
        owner.setLastName("OWNER_LAST_NAME_" + id);
        return owner;
    }

    private Vet createVet(final Long id) {
        final Vet vet = new Vet();
        vet.setId(id);
        vet.setFirstName("VET_FIRST_NAME_" + id);
        vet.setLastName("VET_LAST_NAME_" + id);
        return vet;
    }
}
