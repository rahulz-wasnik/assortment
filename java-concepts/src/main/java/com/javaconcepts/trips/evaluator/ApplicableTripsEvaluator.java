package com.javaconcepts.trips.evaluator;

import com.javaconcepts.trips.entity.TripEvent;
import com.javaconcepts.trips.entity.TripSummary;

import java.util.List;

public interface ApplicableTripsEvaluator {
    List<TripSummary> applicableTrips(TripEvent tripEvent, List<TripSummary> tripSummaries);
}
