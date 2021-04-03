package svalbuena.springframework.sfgpetclinic.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Specialty extends BaseEntity {
    private String description;

    public Specialty(final String description) {
        this.description = description;
    }
}
