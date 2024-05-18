package com.batch.dataload.controller;

import com.batch.dataload.service.ArchivedCustomerService;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class ArchivedCustomerController {

    @Autowired
    private ArchivedCustomerService archivedCustomerService;

    @PostMapping("/create/using-jpa")
    public ResponseEntity<?> create() {
        archivedCustomerService.populateUsingJpa();
        return null;
    }

    @PostMapping("/create/using-jpa-batch")
    public ResponseEntity<?> loadUsingSpringBatch() {
        archivedCustomerService.populateUsingJpaWithBatchConfigurations();
        return null;
    }
}
