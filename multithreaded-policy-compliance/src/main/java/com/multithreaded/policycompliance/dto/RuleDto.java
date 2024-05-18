package com.multithreaded.policycompliance.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RuleDto {
    private int id;
    private String name;
}
