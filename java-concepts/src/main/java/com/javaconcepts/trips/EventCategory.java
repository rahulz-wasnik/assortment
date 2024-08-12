package com.javaconcepts.trips;

import com.javaconcepts.trips.evaluator.ApplicableTripsEvaluator;
import com.javaconcepts.trips.evaluator.ApplicableTripsForDriverEventsEvaluator;
import com.javaconcepts.trips.evaluator.ApplicableTripsForTripEventsEvaluator;

public enum EventCategory {

    TRIP_EVENT {
        @Override
        ApplicableTripsEvaluator getEvaluator() {
            return new ApplicableTripsForTripEventsEvaluator();
        }
    },
    DRIVER_EVENT {
        @Override
        ApplicableTripsEvaluator getEvaluator() {
            return new ApplicableTripsForDriverEventsEvaluator();
        }
    };

    abstract ApplicableTripsEvaluator getEvaluator();
}
