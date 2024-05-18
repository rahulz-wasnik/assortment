package com.multithreaded.policycompliance.repository;

import com.multithreaded.policycompliance.entity.RuleExecutionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RuleExecutionStatusRepository extends JpaRepository<RuleExecutionStatus, Long> {
}
