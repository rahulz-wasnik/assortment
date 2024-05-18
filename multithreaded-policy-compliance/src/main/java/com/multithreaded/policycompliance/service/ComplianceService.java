package com.multithreaded.policycompliance.service;

import com.multithreaded.policycompliance.dto.ComplianceDto;
import com.multithreaded.policycompliance.entity.RuleExecutionStatus;
import com.multithreaded.policycompliance.repository.RuleExecutionStatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class ComplianceService {

    private final ReleaseService releaseService;
    private final PolicyService policyService;
    private final RuleExecutionStatusRepository ruleExecutionStatusRepository;

    public ComplianceService(ReleaseService releaseService, PolicyService policyService, RuleExecutionStatusRepository ruleExecutionStatusRepository) {
        this.releaseService = releaseService;
        this.policyService = policyService;
        this.ruleExecutionStatusRepository = ruleExecutionStatusRepository;
    }

    public ComplianceDto getCompliancePerRelease(String releaseNumber) {
        ComplianceDto complianceDto = CompletableFuture.supplyAsync(() -> this.releaseService.getReleaseDetails(releaseNumber))
                .thenCompose(releaseDetailsDto -> CompletableFuture.supplyAsync(() -> this.policyService.getPolicies(releaseDetailsDto.getRiskProfile())))
                .thenCompose(policies -> CompletableFuture.supplyAsync(() -> this.policyService.getPolicyCompliance(policies)))
                .thenCompose(policyComplianceDetails -> CompletableFuture.supplyAsync(() -> ComplianceDto.builder().releaseNumber(releaseNumber).policies(policyComplianceDetails).build()))
                .join();
        CompletableFuture.runAsync(() -> logComplianceExecutionResults(complianceDto));
        return complianceDto;
    }

    private void logComplianceExecutionResults(ComplianceDto complianceDto) {
        System.out.println(Thread.currentThread().getName() + "saving");
        complianceDto.getPolicies().forEach(p -> {
            List<RuleExecutionStatus> ruleComplianceDetails = p.getRules().stream().map(r -> RuleExecutionStatus.builder().status(r.getComplianceStatus()).build()).toList();
            ruleExecutionStatusRepository.saveAll(ruleComplianceDetails);
        });
    }

}
