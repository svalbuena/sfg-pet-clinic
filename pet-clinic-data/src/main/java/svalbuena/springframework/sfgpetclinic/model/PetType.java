package svalbuena.springframework.sfgpetclinic.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class PetType extends BaseEntity {
    private String name;

    public PetType(final String name) {
        this.name = name;
    }
}
