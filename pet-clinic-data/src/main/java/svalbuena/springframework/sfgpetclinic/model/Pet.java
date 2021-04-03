package svalbuena.springframework.sfgpetclinic.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Data
@EqualsAndHashCode(exclude = "owner", callSuper = true)
@ToString(exclude = "owner")
@Entity
public class Pet extends BaseEntity {
    private String name;

    @ManyToOne
    private PetType petType;

    @ManyToOne
    private Owner owner;

    private LocalDate birthDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
    private Set<Visit> visits = new HashSet<>();

    public Pet(final String name, final PetType petType, final LocalDate birthDate) {
        this.name = name;
        this.petType = petType;
        this.birthDate = birthDate;
    }

    public Pet addVisit(final Visit visit) {
        visit.setPet(this);
        visits.add(visit);
        return this;
    }
}
