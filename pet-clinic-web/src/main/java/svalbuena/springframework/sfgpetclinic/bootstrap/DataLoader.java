package svalbuena.springframework.sfgpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import svalbuena.springframework.sfgpetclinic.model.Owner;
import svalbuena.springframework.sfgpetclinic.model.Pet;
import svalbuena.springframework.sfgpetclinic.model.PetType;
import svalbuena.springframework.sfgpetclinic.model.Vet;
import svalbuena.springframework.sfgpetclinic.services.OwnerService;
import svalbuena.springframework.sfgpetclinic.services.PetTypeService;
import svalbuena.springframework.sfgpetclinic.services.VetService;

import java.time.LocalDate;

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
        final PetType dogType = petTypeService.save(createPetType("dog"));
        final PetType catType = petTypeService.save(createPetType("cat"));

        final Owner owner1 = createOwner("John", "Howards");
        final Pet dog1 = createPet("Bimbo", dogType, owner1);
        owner1.getPets().add(dog1);
        final Pet cat1 = createPet("Miau", catType, owner1);
        owner1.getPets().add(cat1);
        ownerService.save(owner1);

        final Owner owner2 = createOwner("Peter", "Samuels");
        final Pet cat2 = createPet("Gulp", catType, owner2);
        owner2.getPets().add(cat2);
        final Pet cat3 = createPet("Birp", catType, owner2);
        owner2.getPets().add(cat3);
        ownerService.save(owner2);

        vetService.save(createVet("Key", "Master"));
        vetService.save(createVet("Anna", "Limp"));

        System.out.println("Loaded!!");
    }

    private Owner createOwner(final String firstName, final String lastName) {
        final Owner owner = new Owner();
        owner.setFirstName(firstName);
        owner.setLastName(lastName);
        owner.setAddress("123 Street");
        owner.setCity("Miami");
        owner.setTelephone("89131233121");
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

    private Pet createPet(final String name, final PetType type, final Owner owner) {
        final Pet pet = new Pet();
        pet.setName(name);
        pet.setType(type);
        pet.setOwner(owner);
        pet.setBirthDate(LocalDate.now());
        return pet;
    }
}
