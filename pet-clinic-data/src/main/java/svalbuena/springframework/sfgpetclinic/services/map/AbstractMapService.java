package svalbuena.springframework.sfgpetclinic.services.map;

import svalbuena.springframework.sfgpetclinic.model.BaseEntity;
import svalbuena.springframework.sfgpetclinic.services.CrudService;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractMapService<T extends BaseEntity> implements CrudService<T, Long> {
    protected Map<Long, T> map = new HashMap<>();

    @Override
    public T findById(final Long id) {
        return map.get(id);
    }

    @Override
    public Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    @Override
    public T save(final T object) {
        if (object.doesNotHaveId()) {
            object.setId(getNextId());
        }
        map.put(object.getId(), object);
        return object;
    }

    @Override
    public void delete(final T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    @Override
    public void deleteById(final Long id) {
        map.remove(id);
    }

    private Long getNextId() {
        return map.isEmpty()
                ? 0L
                : Collections.max(map.keySet()) + 1L;
    }
}
