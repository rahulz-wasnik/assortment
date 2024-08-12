package com.javaconcepts.trips;

import com.javaconcepts.trips.entity.TripEvent;
import com.javaconcepts.trips.entity.TripSummary;
import com.javaconcepts.trips.event.action.*;

import static com.javaconcepts.trips.EventCategory.*;

public enum EventType {
    TRIP_STARTED(TRIP_EVENT),
    DRIVER_REMOVED(DRIVER_EVENT);

    private EventCategory eventCategory;

    EventType(EventCategory eventCategory) {this.eventCategory = eventCategory;}

    public void executeEventActionBasedOnCategory(TripEvent tripEvent, TripSummary tripSummary, TripSummaryRepostiory tripSummaryRepostiory) {
        switch (tripEvent.getEventType().eventCategory) {
            case TRIP_EVENT -> getTripEventAction(tripEvent.getEventType()).applyTo(tripEvent, tripSummary);
            case DRIVER_EVENT -> getDriverEventAction(tripEvent.getEventType()).applyTo(tripEvent, tripSummary, tripSummaryRepostiory);
        }
    }

    private TripEventAction getTripEventAction(EventType eventType) {
        switch (eventType) {
            case TRIP_STARTED: return new TripStartedEventAction();
            default: throw new IllegalArgumentException();
        }
    }

    private DriverEventAction getDriverEventAction(EventType eventType) {
        switch (eventType) {
            case DRIVER_REMOVED: return new DriverRemovedEventAction();
            default: throw new IllegalArgumentException();
        }
    }

}
