package svalbuena.springframework.sfgpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import svalbuena.springframework.sfgpetclinic.model.Owner;
import svalbuena.springframework.sfgpetclinic.model.Pet;
import svalbuena.springframework.sfgpetclinic.model.PetType;
import svalbuena.springframework.sfgpetclinic.model.Specialty;
import svalbuena.springframework.sfgpetclinic.model.Vet;
import svalbuena.springframework.sfgpetclinic.model.Visit;
import svalbuena.springframework.sfgpetclinic.services.OwnerService;
import svalbuena.springframework.sfgpetclinic.services.PetTypeService;
import svalbuena.springframework.sfgpetclinic.services.SpecialtyService;
import svalbuena.springframework.sfgpetclinic.services.VetService;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final PetTypeService petTypeService;
    private final VetService vetService;
    private final SpecialtyService specialtyService;

    public DataLoader(final OwnerService ownerService,
                      final PetTypeService petTypeService,
                      final VetService vetService,
                      final SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.petTypeService = petTypeService;
        this.vetService = vetService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(final String... args) {
        if (petTypeService.findAll().isEmpty()) {
            loadData();
        }
    }

    private void loadData() {
        final PetType dogType = petTypeService.save(createPetType("dog"));
        final PetType catType = petTypeService.save(createPetType("cat"));

        final Owner owner1 = createOwner("John", "Howards");
        final Pet dog1 = createPet("Bimbo", dogType);
        dog1
                .addVisit(createVisit("Visit for broken leg"))
                .addVisit(createVisit("Visit for RX"));
        owner1
                .addPet(dog1)
                .addPet(createPet("Luke", dogType));
        ownerService.save(owner1);

        final Owner owner2 = createOwner("Peter", "Samuels");
        final Pet cat1 = createPet("Gulp", catType);
        cat1.addVisit(createVisit("Visit for fever"));
        owner2
                .addPet(cat1)
                .addPet(createPet("Birp", catType));
        ownerService.save(owner2);

        final Specialty dentistry = specialtyService.save(createSpecialty("dentistry"));
        final Specialty radiology = specialtyService.save(createSpecialty("radiology"));
        final Specialty surgery = specialtyService.save(createSpecialty("surgery"));

        final Vet vet1 = createVet("Key", "Master");
        vet1.addSpecialty(dentistry);
        vetService.save(vet1);

        final Vet vet2 = createVet("Anna", "Limp");
        vet2
                .addSpecialty(radiology)
                .addSpecialty(surgery);
        vetService.save(vet2);

        System.out.println("Loaded!!");
    }

    private Owner createOwner(final String firstName, final String lastName) {
        return new Owner(firstName, lastName, "123 Street", "Miami", "89131233121");
    }

    private PetType createPetType(final String name) {
        return new PetType(name);
    }

    private Pet createPet(final String name, final PetType type) {
        return new Pet(name, type, LocalDate.EPOCH);
    }

    private Vet createVet(final String firstName, final String lastName) {
        return new Vet(firstName, lastName);
    }

    private Specialty createSpecialty(final String description) {
        return new Specialty(description);
    }

    private Visit createVisit(final String description) {
        return new Visit(description, LocalDate.now());
    }
}
