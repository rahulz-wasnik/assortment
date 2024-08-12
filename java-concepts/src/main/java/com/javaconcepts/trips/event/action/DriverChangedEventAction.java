package com.javaconcepts.trips.event.action;

import com.javaconcepts.trips.TripSummaryRepostiory;
import com.javaconcepts.trips.entity.TripEvent;
import com.javaconcepts.trips.entity.TripSummary;

public class DriverChangedEventAction implements DriverEventAction {
    @Override
    public void modifyTrip(TripEvent tripEvent, TripSummary tripSummary, TripSummaryRepostiory tripSummaryRepostiory) {
        System.out.println("DriverChangedEventAction................");
    }
}
