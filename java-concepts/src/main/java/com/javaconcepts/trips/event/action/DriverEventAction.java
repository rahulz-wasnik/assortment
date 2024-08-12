package com.javaconcepts.trips.event.action;

import com.javaconcepts.trips.TripSummaryRepostiory;
import com.javaconcepts.trips.entity.TripEvent;
import com.javaconcepts.trips.entity.TripSummary;

public interface DriverEventAction extends EventAction {

    void modifyTrip(TripEvent tripEvent, TripSummary tripSummary, TripSummaryRepostiory tripSummaryRepostiory);

    default void applyTo(TripEvent tripEvent, TripSummary tripSummary, TripSummaryRepostiory tripSummaryRepostiory) {
        modifyTrip(tripEvent, tripSummary, tripSummaryRepostiory);
    }
}
