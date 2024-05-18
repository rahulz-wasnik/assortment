package com.multithreaded.policycompliance.controller;

import com.multithreaded.policycompliance.dto.ComplianceDto;
import com.multithreaded.policycompliance.service.ComplianceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compliance")
public class ComplianceController {

    @Autowired
    private ComplianceService complianceService;

    @GetMapping("/{releaseNumber}")
    public ResponseEntity<ComplianceDto> getCompliance(@PathVariable String releaseNumber) {
        System.out.println(Thread.currentThread().getName() + "Starting");
        ComplianceDto complianceDto = complianceService.getCompliancePerRelease(releaseNumber);
        System.out.println(Thread.currentThread().getName() + "Ending");
        return ResponseEntity.ok(complianceDto);
    }
}
