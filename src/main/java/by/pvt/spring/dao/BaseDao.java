package by.pvt.spring.dao;

import by.pvt.spring.entity.BaseEntity;
import lombok.Cleanup;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;
import java.util.Optional;

public interface BaseDao<T extends Serializable, E extends BaseEntity<T>> {

    SessionFactory getSessionFactory();

    default T save(E entity) {
        @Cleanup Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
        return entity.getId();
    }

    /*default Optional<E> get(T id) {
        @Cleanup Session session = getSessionFactory().openSession();
        return Optional.ofNullable()
    }*/
}
