package com.batch.dataload.repository;

import com.batch.dataload.entity.JobDetailsEntity;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface JobDetailsRepository extends JpaRepository<JobDetailsEntity, Long> {

    @Transactional
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select j from JobDetailsEntity j where j.id=:id")
    Optional<JobDetailsEntity> findByIdForUpdate(Long id);
}
