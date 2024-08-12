package com.javaconcepts.trips.evaluator;

import com.javaconcepts.trips.entity.TripEvent;
import com.javaconcepts.trips.entity.TripSummary;

import java.util.List;

public class ApplicableTripsForDriverEventsEvaluator implements ApplicableTripsEvaluator{
    @Override
    public List<TripSummary> applicableTrips(TripEvent tripEvent, List<TripSummary> tripSummaries) {
        return List.of();
    }
}
