package com.scheduler.concurrency.repository;

import com.scheduler.concurrency.entity.JobStatusEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.persistence.LockModeType;
import java.util.Map;


@Repository
public interface JobStatusRepository extends PagingAndSortingRepository<JobStatusEntity, Long> {

    String GET_JOB_STATUSES = "select a.*, b.job_description, b.job_name" +
            " from `scheduled-concurrency`.job_status as a inner join `scheduled-concurrency`.job_configuration as b"+
            " where b.id = a.job_id"
            ;

    @Query(value = GET_JOB_STATUSES, nativeQuery = true)
    Page<Map<String, Object>> findJobStatuses(Pageable pageable);

}
