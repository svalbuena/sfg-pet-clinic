package svalbuena.springframework.sfgpetclinic.services;

import java.util.Set;

public interface CrudService<T, ID> {
    T findById(final ID id);
    Set<T> findAll();
    T save(final T object);
    void delete(final T object);
    void deleteById(final ID id);
}
