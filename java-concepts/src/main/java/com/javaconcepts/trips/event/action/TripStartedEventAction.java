package com.javaconcepts.trips.event.action;

import com.javaconcepts.trips.entity.TripEvent;
import com.javaconcepts.trips.entity.TripSummary;

public class TripStartedEventAction implements TripEventAction {
    @Override
    public void modifyTrip(TripEvent tripEvent, TripSummary tripSummary) {
        System.out.println("TripStartedEventAction................");
    }
}
