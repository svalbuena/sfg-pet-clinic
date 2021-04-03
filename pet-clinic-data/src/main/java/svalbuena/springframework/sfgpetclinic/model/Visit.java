package svalbuena.springframework.sfgpetclinic.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@NoArgsConstructor
@Data
@EqualsAndHashCode(exclude = "pet", callSuper = true)
@ToString(exclude = "pet")
@Entity
public class Visit extends BaseEntity {
    private LocalDate date;

    private String description;

    @ManyToOne
    private Pet pet;

    public Visit(final String description, final LocalDate date) {
        this.description = description;
        this.date = date;
    }
}
