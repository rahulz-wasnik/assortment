package com.multithreaded.policycompliance.service;

import com.multithreaded.policycompliance.dto.ReleaseDetailsDto;
import org.springframework.stereotype.Service;

@Service
public class ReleaseService {

    public ReleaseDetailsDto getReleaseDetails(String releaseNumber) {
        return ReleaseDetailsDto.builder().riskProfile("High").build();
    }
}
