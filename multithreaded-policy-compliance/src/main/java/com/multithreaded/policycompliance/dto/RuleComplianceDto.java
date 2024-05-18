package com.multithreaded.policycompliance.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RuleComplianceDto {

    private String name;
    private String complianceStatus;
}
