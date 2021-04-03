package svalbuena.springframework.sfgpetclinic.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Owner extends Person {
    private String address;

    private String city;

    private String telephone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();

    public Owner(final String firstName, final String lastName, final String address, final String city, final String telephone) {
        super(firstName, lastName);
        this.address = address;
        this.city = city;
        this.telephone = telephone;
    }

    public Owner addPet(final Pet pet) {
        pet.setOwner(this);
        pets.add(pet);
        return this;
    }
}
