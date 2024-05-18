package com.multithreaded.policycompliance.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PolicyDto {

    private int id;
    private String name;
    private List<RuleDto> rules;
}
