package org.example;

import jakarta.persistence.EntityManager;
import org.example.model.PublishingHouse;
import org.springframework.stereotype.Repository;

@Repository
public class PublishingHouseRepository extends AbstractRepository<PublishingHouse, Long> {
    public PublishingHouseRepository(EntityManager entityManager) {
        super(PublishingHouse.class);
    }

}