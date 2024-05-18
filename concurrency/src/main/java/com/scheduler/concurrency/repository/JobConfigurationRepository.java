package com.scheduler.concurrency.repository;

import com.scheduler.concurrency.entity.JobConfigurationEntity;
import com.scheduler.concurrency.entity.JobStatusEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface JobConfigurationRepository extends JpaRepository<JobConfigurationEntity, Long> {

    JobConfigurationEntity findByJobName(String jobName);

}
