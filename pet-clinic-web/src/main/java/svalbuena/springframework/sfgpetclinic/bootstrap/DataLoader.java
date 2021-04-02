package svalbuena.springframework.sfgpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import svalbuena.springframework.sfgpetclinic.model.Owner;
import svalbuena.springframework.sfgpetclinic.model.PetType;
import svalbuena.springframework.sfgpetclinic.model.Vet;
import svalbuena.springframework.sfgpetclinic.services.OwnerService;
import svalbuena.springframework.sfgpetclinic.services.PetTypeService;
import svalbuena.springframework.sfgpetclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(final OwnerService ownerService,
                      final VetService vetService,
                      final PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(final String... args) {
        petTypeService.save(createPetType("dog"));
        petTypeService.save(createPetType("cat"));

        ownerService.save(createOwner("John", "Howards"));
        ownerService.save(createOwner("Peter", "Samuels"));

        vetService.save(createVet("Key", "Master"));
        vetService.save(createVet("Anna", "Limp"));

        System.out.println("Loaded!!");
    }

    private Owner createOwner(final String firstName, final String lastName) {
        final Owner owner = new Owner();
        owner.setFirstName(firstName);
        owner.setLastName(lastName);
        return owner;
    }

    private Vet createVet(final String firstName, final String lastName) {
        final Vet vet = new Vet();
        vet.setFirstName(firstName);
        vet.setLastName(lastName);
        return vet;
    }

    private PetType createPetType(final String name) {
        final PetType petType = new PetType();
        petType.setName(name);
        return petType;
    }
}
