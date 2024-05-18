package com.batch.dataload.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "JOB_DETAILS")
public class JobDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "JOB_DETAILS_ID_SEQ")
    @SequenceGenerator(name = "JOB_DETAILS_ID_SEQ" ,sequenceName = "JOB_DETAILS_ID_SEQ", allocationSize = 1, initialValue = 1)
    private Long id;
    private String name;
    private String jobStatus;
}
