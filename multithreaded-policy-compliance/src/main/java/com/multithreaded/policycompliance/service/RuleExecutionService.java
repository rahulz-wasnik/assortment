package com.multithreaded.policycompliance.service;

import com.multithreaded.policycompliance.dto.RuleComplianceDto;
import com.multithreaded.policycompliance.dto.RuleDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class RuleExecutionService {

    public List<RuleComplianceDto> getRuleCompliance(List<RuleDto> rules) {
        List<CompletableFuture<RuleComplianceDto>> list = rules.stream().map((r) -> CompletableFuture.supplyAsync(() -> this.executeRule(r))).toList();
        return list.stream().map(CompletableFuture::join).toList();
    }

    private RuleComplianceDto executeRule(RuleDto rule) {
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return RuleComplianceDto.builder().name(rule.getName()).complianceStatus("C").build();
    }
}
