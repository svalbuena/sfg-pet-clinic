package svalbuena.springframework.sfgpetclinic.model;

import java.io.Serializable;

public abstract class BaseEntity implements Serializable {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public boolean doesNotHaveId() {
        return id == null;
    }
}
