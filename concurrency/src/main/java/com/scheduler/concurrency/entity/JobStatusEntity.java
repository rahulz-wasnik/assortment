package com.scheduler.concurrency.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "JOB_STATUS")
@Builder
public class JobStatusEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SEQ_JOB_STATUS")
    @SequenceGenerator(
            name="SEQ_JOB_STATUS",
            sequenceName="SEQ_JOB_STATUS"
    )
    private Long id;

    @Column(name = "JOB_STATUS")
    private String jobStatus;

    @Column(name = "JOB_START_DATE_TIME")
    private LocalDateTime jobStartDateTime;

    @Column(name = "JOB_END_DATE_TIME")
    private LocalDateTime jobEndDateTime;

    @Column(name = "TOTAL_EXECUTION_TIME")
    private String totalExecutionTime;

    @ManyToOne
    @JoinColumn(name = "JOB_ID")
    private JobConfigurationEntity jobConfigurationEntity;
}
