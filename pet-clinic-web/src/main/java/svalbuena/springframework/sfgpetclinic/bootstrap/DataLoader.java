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
                .addPet(createPet("Bimbo", dogType));
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
        final Owner owner = new Owner();
        owner.setFirstName(firstName);
        owner.setLastName(lastName);
        owner.setAddress("123 Street");
        owner.setCity("Miami");
        owner.setTelephone("89131233121");
        return owner;
    }

    private PetType createPetType(final String name) {
        final PetType petType = new PetType();
        petType.setName(name);
        return petType;
    }

    private Pet createPet(final String name, final PetType type) {
        final Pet pet = new Pet();
        pet.setName(name);
        pet.setPetType(type);
        pet.setBirthDate(LocalDate.now());
        return pet;
    }

    private Vet createVet(final String firstName, final String lastName) {
        final Vet vet = new Vet();
        vet.setFirstName(firstName);
        vet.setLastName(lastName);
        return vet;
    }

    private Specialty createSpecialty(final String description) {
        final Specialty speciality = new Specialty();
        speciality.setDescription(description);
        return speciality;
    }

    private Visit createVisit(final String description) {
        final Visit visit = new Visit();
        visit.setDescription(description);
        visit.setDate(LocalDate.now());
        return visit;
    }
}
