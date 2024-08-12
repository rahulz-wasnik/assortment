package com.javaconcepts.trips.event.action;

import com.javaconcepts.trips.entity.TripEvent;
import com.javaconcepts.trips.entity.TripSummary;

public interface TripEventAction extends EventAction {

    void modifyTrip(TripEvent tripEvent, TripSummary tripSummary);

    default void applyTo(TripEvent tripEvent, TripSummary tripSummary) {
        modifyTrip(tripEvent, tripSummary);
    }
}
