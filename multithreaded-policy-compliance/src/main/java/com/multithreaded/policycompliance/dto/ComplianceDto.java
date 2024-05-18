package com.multithreaded.policycompliance.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ComplianceDto {

    private String releaseNumber;
    private String riskProfile;
    private List<PolicyComplianceDto> policies;
}
