package com.scheduler.concurrency.service;

import com.scheduler.concurrency.entity.JobConfigurationEntity;
import com.scheduler.concurrency.entity.JobStatusEntity;
import com.scheduler.concurrency.repository.CustomJobStatusRepository;
import com.scheduler.concurrency.repository.JobConfigurationRepository;
import com.scheduler.concurrency.repository.JobStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Map;

@Service
public class JobTrackerService {

    @Autowired
    private JobStatusRepository jobStatusRepository;

    @Autowired
    private CustomJobStatusRepository customJobStatusRepository;

    @Autowired
    private JobConfigurationRepository jobConfigurationRepository;

    public Page<JobStatusEntity> findJobStatuses(int page, int size) {
        Sort.Direction direction = Sort.Direction.DESC;
        Sort sort = Sort.by(direction, "id");
        PageRequest pageable = PageRequest.of(page, size, sort);
        return jobStatusRepository.findAll(pageable);
    }

    @Transactional()
    public JobStatusEntity markJobStart(String jobName) {
        JobConfigurationEntity jobConfigurationEntity = jobConfigurationRepository.findByJobName(jobName);
        JobStatusEntity jobStatus = JobStatusEntity.builder()
                .jobStartDateTime(LocalDateTime.now())
                .jobStatus("RUNNING")
                .jobConfigurationEntity(jobConfigurationEntity)
                .build();
        jobStatus = customJobStatusRepository.save(jobStatus);
        for (JobStatusEntity e: jobStatusRepository.findAll()) {
            System.out.println("Running" + e.getJobConfigurationEntity().getJobName());
        }
        return jobStatus;
    }

    public void markJobEndTime(JobStatusEntity jobStatus) {
        jobStatus.setJobStatus("COMPLETED");
        LocalDateTime jobStartTime = jobStatus.getJobStartDateTime();
        LocalDateTime jobEndTime = LocalDateTime.now();

        Duration duration = Duration.between(jobStartTime, jobEndTime);
        long hours = duration.toHours();
        long minutes = duration.toMinutes();
        long seconds = duration.toSeconds();

        String totalExecutionTime = String.format("%s hrs : %s mins : %s seconds",
                Long.valueOf(hours).toString(), Long.valueOf(minutes).toString(), Long.valueOf(seconds).toString());

        jobStatus.setJobEndDateTime(jobEndTime);
        jobStatus.setTotalExecutionTime(totalExecutionTime);
        System.out.println("totalExecutionTime - "+totalExecutionTime);
        customJobStatusRepository.save(jobStatus);
    }
}
