package org.example;

import jakarta.persistence.*;
import java.util.List;

public abstract class AbstractRepository<T, ID> {
    protected Class<T> entityClass;

    public AbstractRepository(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public void create(T entity) {
        EntityManager entityManager = Singleton.EntityManagerFactoryProvider.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(entity);
        transaction.commit();
        entityManager.close();
    }

    public T findById(ID id) {
        EntityManager entityManager = Singleton.EntityManagerFactoryProvider.getEntityManager();
        T entity = entityManager.find(entityClass, id);
        entityManager.close();
        return entity;
    }

    public void update(T entity) {
        EntityManager entityManager = Singleton.EntityManagerFactoryProvider.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(entity);
        transaction.commit();
        entityManager.close();
    }

    public void delete(ID id) {
        EntityManager entityManager = Singleton.EntityManagerFactoryProvider.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        T entity = entityManager.find(entityClass, id);
        entityManager.remove(entity);
        transaction.commit();
        entityManager.close();
    }
}
