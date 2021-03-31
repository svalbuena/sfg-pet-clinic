package svalbuena.springframework.sfgpetclinic.services.map;

import org.junit.jupiter.api.Test;
import svalbuena.springframework.sfgpetclinic.services.CrudService;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

abstract class AbstractMapServiceTest<T, ID> {
    protected CrudService<T, ID> service;

    abstract T givenObject();
    abstract ID getObjectId(final T object);

    @Test
    void testFindById() {
        final T object = givenObject();

        service.save(object);
        final T actualObject = service.findById(getObjectId(object));

        assertThat(actualObject).isEqualTo(object);
    }

    @Test
    void testFindAll() {
        final T object1 = givenObject();
        final T object2 = givenObject();
        final Set<T> expectedObjects = new HashSet<>();
        expectedObjects.add(object1);
        expectedObjects.add(object2);

        service.save(object1);
        service.save(object2);
        final Set<T> actualObjects = service.findAll();

        assertThat(actualObjects).containsOnlyOnceElementsOf(expectedObjects);
    }

    @Test
    void testDelete() {
        final T object = givenObject();

        service.save(object);
        service.delete(object);
        final Object actualObject = service.findById(getObjectId(object));

        assertThat(actualObject).isNull();
    }

    @Test
    void testDeleteById() {
        final T object = givenObject();

        service.save(object);
        service.deleteById(getObjectId(object));
        final Object actualObject = service.findById(getObjectId(object));

        assertThat(actualObject).isNull();
    }
}