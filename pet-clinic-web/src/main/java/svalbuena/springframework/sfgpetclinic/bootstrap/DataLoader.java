package svalbuena.springframework.sfgpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import svalbuena.springframework.sfgpetclinic.model.Owner;
import svalbuena.springframework.sfgpetclinic.model.Vet;
import svalbuena.springframework.sfgpetclinic.services.OwnerService;
import svalbuena.springframework.sfgpetclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(final OwnerService ownerService, final VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(final String... args) {
        ownerService.save(createOwner());
        ownerService.save(createOwner());

        vetService.save(createVet());
        vetService.save(createVet());

        System.out.println("Loaded!!");
    }

    private Owner createOwner() {
        final Owner owner = new Owner();
        owner.setFirstName("OWNER_FIRST_NAME");
        owner.setLastName("OWNER_LAST_NAME");
        return owner;
    }

    private Vet createVet() {
        final Vet vet = new Vet();
        vet.setFirstName("VET_FIRST_NAME");
        vet.setLastName("VET_LAST_NAME");
        return vet;
    }
}
