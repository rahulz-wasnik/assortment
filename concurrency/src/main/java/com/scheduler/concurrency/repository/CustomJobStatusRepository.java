package com.scheduler.concurrency.repository;

import com.scheduler.concurrency.entity.JobStatusEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;

@Component
public class CustomJobStatusRepository {

    @Autowired
    private EntityManager entityManager;

    @Transactional(isolation = Isolation.SERIALIZABLE)
//    @Lock(LockModeType.PESSIMISTIC_WRITE)
    public JobStatusEntity save(JobStatusEntity entity) {
        Assert.notNull(entity, "Entity must not be null.");
        if (null == entity.getId()) {
            this.entityManager.persist(entity);
            return entity;
        } else {
            return this.entityManager.merge(entity);
        }
    }
}
