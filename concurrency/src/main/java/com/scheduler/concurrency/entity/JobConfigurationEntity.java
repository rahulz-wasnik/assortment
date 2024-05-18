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
@Table(name = "JOB_CONFIGURATION")
@Builder
public class JobConfigurationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SEQ_JOB_CONFIGURATION")
    @SequenceGenerator(
            name="SEQ_JOB_CONFIGURATION",
            sequenceName="SEQ_JOB_CONFIGURATION"
    )
    private Long id;

    @Column(name = "JOB_NAME")
    private String jobName;

    @Column(name = "JOB_DESCRIPTION")
    private String jobDescription;
}
