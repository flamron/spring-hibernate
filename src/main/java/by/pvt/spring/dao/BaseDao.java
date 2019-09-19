package by.pvt.spring.dao;

import by.pvt.spring.entity.BaseEntity;
import lombok.Cleanup;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.core.GenericTypeResolver;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
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

    default Optional<E> get(T id) {
        @Cleanup Session session = getSessionFactory().openSession();
        return Optional.ofNullable(session.get(getClazz(), id));
    }

    default void update(E entity) {
        @Cleanup Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
    }

    default void delete(E entity) {
        @Cleanup Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(entity);
        session.getTransaction().commit();
    }

    default List<E> getAll() {
        @Cleanup Session session = getSessionFactory().openSession();
        Class<E> clazz = getClazz();
        return session.createQuery(String.format("select e from %s e", clazz.getSimpleName()), clazz).list();
    }

    @SuppressWarnings("unchecked")
    default Class<E> getClazz() {
        return (Class<E>) GenericTypeResolver.resolveTypeArguments(getClass(), BaseDao.class)[1];
        /*Type entityType = ((ParameterizedType) getClass().getGenericInterfaces()[0]).getActualTypeArguments()[1];
        return (Class<E>) entityType;*/
    }
}













