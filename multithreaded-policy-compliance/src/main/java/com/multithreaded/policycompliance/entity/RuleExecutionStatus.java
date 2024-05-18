package com.multithreaded.policycompliance.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@Table(name = "RULE_EXECUTION_STATUS")
public class RuleExecutionStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RULE_EXECUTION_SEQ")
    @SequenceGenerator(name = "RULE_EXECUTION_SEQ" ,sequenceName = "RULE_EXECUTION_SEQ", allocationSize = 1, initialValue = 1)
    private Long id;

    @Column(name = "STATUS")
    private String status;
}
