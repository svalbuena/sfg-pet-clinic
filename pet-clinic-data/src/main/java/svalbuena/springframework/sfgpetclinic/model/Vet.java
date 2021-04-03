package svalbuena.springframework.sfgpetclinic.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Vet extends Person {
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "vet_specialty", joinColumns = @JoinColumn(name = "vet_id"), inverseJoinColumns = @JoinColumn(name = "specialty_id"))
    private Set<Specialty> specialties = new HashSet<>();

    public Vet(final String firstName, final String lastName) {
        super(firstName, lastName);
    }

    public Vet addSpecialty(final Specialty specialty) {
        specialties.add(specialty);
        return this;
    }
}
