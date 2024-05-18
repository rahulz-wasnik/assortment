package com.scheduler.concurrency.repository;

import com.scheduler.concurrency.entity.OldEmployeeRecordsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OldEmployeeRecordRepository extends JpaRepository<OldEmployeeRecordsEntity, Long> {
}
