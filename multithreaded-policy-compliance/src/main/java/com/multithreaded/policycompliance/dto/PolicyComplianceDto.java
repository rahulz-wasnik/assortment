package com.multithreaded.policycompliance.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PolicyComplianceDto {

    private String name;
    private String complianceStatus;
    private List<RuleComplianceDto> rules;
}
