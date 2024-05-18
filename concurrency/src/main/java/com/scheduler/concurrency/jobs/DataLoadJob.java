package com.scheduler.concurrency.jobs;

import com.scheduler.concurrency.entity.JobStatusEntity;
import com.scheduler.concurrency.service.DataLoadAndCopyService;
import com.scheduler.concurrency.service.JobTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.*;

//@Component
public class DataLoadJob {

    @Autowired
    private JobTrackerService jobTrackerService;

    @Autowired
    private DataLoadAndCopyService dataLoadAndCopyService;
    @Scheduled(fixedRate = 7000)
    public void loadAndCopyReleaseDetails() {
        try {
            System.out.println("Commenced job to load and save release details");
            JobStatusEntity jobStatus = jobTrackerService.markJobStart("Release details data load");
//            dataLoadAndCopyService.loadAndCopyEmployeeData();
            jobTrackerService.markJobEndTime(jobStatus);
            System.out.println("Finished execution of release details job");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Scheduled(fixedRate = 5000)
    public void loadAndCopyNarDetails() {
        try {
            System.out.println("Commenced job to load and save nar details");
            JobStatusEntity jobStatus = jobTrackerService.markJobStart("Nar details data load");
//            dataLoadAndCopyService.loadAndCopyEmployeeData();
            jobTrackerService.markJobEndTime(jobStatus);
            System.out.println("Finished execution of nar details job");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Create a LocalDateTime
        LocalDateTime localDateTime = LocalDateTime.now();

        // Convert LocalDateTime to Instant in UTC
        Instant instant = localDateTime.atZone(ZoneOffset.UTC).toInstant();

        // If you want to convert Instant back to LocalDateTime
        LocalDateTime convertedLocalDateTime = instant.atOffset(ZoneOffset.UTC).toLocalDateTime();

        // Print the results
        System.out.println("Original LocalDateTime: " + localDateTime);
        System.out.println("Instant: "+Instant.now());
        System.out.println("Converted Instant in UTC: " + instant);
        System.out.println("Converted back to LocalDateTime: " + convertedLocalDateTime);
        System.out.println("Zoned date time"+ ZonedDateTime.now(ZoneId.of("UTC")));
    }


}
