package com.batch.dataload.service;

import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;

@Service
public class TimeService {

    public void logTotalTimeTakenForExecution(LocalDateTime start, LocalDateTime end) {
        Duration duration = Duration.between(start, end);

        int MINUTES_PER_HOUR = 60;
        int SECONDS_PER_MINUTE = 60;
        int SECONDS_PER_HOUR = SECONDS_PER_MINUTE * MINUTES_PER_HOUR;

        long seconds = duration.getSeconds();

        long hours = seconds / SECONDS_PER_HOUR;
        long minutes = ((seconds % SECONDS_PER_HOUR) / SECONDS_PER_MINUTE);
        long secs = (seconds % SECONDS_PER_MINUTE);
        System.out.println(hours + " " + minutes + " " + secs);
    }
}
