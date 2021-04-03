package svalbuena.springframework.sfgpetclinic.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.MappedSuperclass;

@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
public class Person extends BaseEntity {
    private String firstName;
    private String lastName;

    public Person(final String firstName, final String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
