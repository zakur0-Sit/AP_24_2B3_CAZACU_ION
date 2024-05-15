package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import static org.example.Singleton.EntityManagerFactoryProvider.entityManagerFactory;

public class Singleton {

    private static final Singleton INSTANCE=new Singleton();
    private final EntityManagerFactory emf;

    private Singleton(){
        emf= Persistence.createEntityManagerFactory("book_pu");
    }

    public static Singleton getInstance(){
        return INSTANCE;
    }

    public static void closeEntityManagerFactory() {
        if (entityManagerFactory != null && entityManagerFactory.isOpen()) {
            entityManagerFactory.close();
        }
    }

    public EntityManagerFactory getEntityManagerFactory(){
        return emf;
    }

    public class EntityManagerFactoryProvider {
        private static final String PERSISTENCE_UNIT_NAME = "book_pu";

        static EntityManagerFactory entityManagerFactory;

        public static EntityManager getEntityManager() {
            if (entityManagerFactory == null) {
                entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            }
            return entityManagerFactory.createEntityManager();
        }

    }

}
