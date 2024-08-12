package com.javaconcepts.trips;

import com.javaconcepts.trips.entity.TripEvent;
import com.javaconcepts.trips.entity.TripSummary;

import java.util.List;

public class EnumApplicationsInAction {

    public static void main(String[] args) {
        TripEvent tripEvent = new TripEvent(EventType.DRIVER_REMOVED);
        TripSummary tripSummary = new TripSummary(List.of(tripEvent));
        TripSummaryRepostiory tripSummaryRepostiory = new TripSummaryRepostiory();

        tripEvent.applyTo(tripSummary, tripSummaryRepostiory);
    }
}
