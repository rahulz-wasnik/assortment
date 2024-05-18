package com.multithreaded.policycompliance.service;

import com.multithreaded.policycompliance.dto.PolicyComplianceDto;
import com.multithreaded.policycompliance.dto.PolicyDto;
import com.multithreaded.policycompliance.dto.RuleDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

@Service
public class PolicyService {

    private final RuleExecutionService ruleExecutionService;

    public PolicyService(RuleExecutionService ruleExecutionService) {
        this.ruleExecutionService = ruleExecutionService;
    }

    public List<PolicyDto> getPolicies(String riskProfile) {
        return getPolicies();
    }

    private List<PolicyDto> getPolicies() {
        return IntStream.range(0, 5).mapToObj(i -> PolicyDto.builder().id(i).name("Policy "+ i).rules(getRules()).build()).toList();
    }
    private List<RuleDto> getRules() {
        return IntStream.range(0, 5).mapToObj(i -> RuleDto.builder().id(i).name("Rule "+ i).build()).toList();
    }

    public List<PolicyComplianceDto> getPolicyCompliance(List<PolicyDto> policies) {
        List<CompletableFuture<PolicyComplianceDto>> list = policies.parallelStream().map(p -> CompletableFuture.supplyAsync(() -> PolicyComplianceDto.builder()
                .name(p.getName())
                .rules(ruleExecutionService.getRuleCompliance(p.getRules()))
                .complianceStatus("C")
                .build())).toList();
        return list.stream().map(CompletableFuture::join).toList();
    }
}
