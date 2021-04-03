package svalbuena.springframework.sfgpetclinic.services.springdatajpa;

import org.springframework.data.repository.CrudRepository;
import svalbuena.springframework.sfgpetclinic.model.BaseEntity;
import svalbuena.springframework.sfgpetclinic.services.CrudService;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public abstract class AbstractJpaService<T extends BaseEntity, ID extends Long, R extends CrudRepository<T, ID>> implements CrudService<T, ID> {
    private final R repository;

    public AbstractJpaService(final R repository) {
        this.repository = repository;
    }

    @Override
    public T findById(final ID id) {
        return repository.findById(id)
                .orElse(null);
    }

    @Override
    public Set<T> findAll() {
        final Iterable<T> objects = repository.findAll();
        return StreamSupport.stream(objects.spliterator(), false)
                .collect(Collectors.toSet());
    }

    @Override
    public T save(final T object) {
        return repository.save(object);
    }

    @Override
    public void delete(final T object) {
        repository.delete(object);
    }

    @Override
    public void deleteById(final ID id) {
        repository.deleteById(id);
    }
}
