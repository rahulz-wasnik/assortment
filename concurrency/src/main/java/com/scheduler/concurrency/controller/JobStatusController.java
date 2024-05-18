package com.scheduler.concurrency.controller;

import com.scheduler.concurrency.entity.JobStatusEntity;
import com.scheduler.concurrency.service.JobTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/job/statuses")
public class JobStatusController {

    @Autowired
    private JobTrackerService jobTrackerService;

    @GetMapping()
    public Page<JobStatusEntity> getJobStatuses(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return jobTrackerService.findJobStatuses(page, size);

    }
}
