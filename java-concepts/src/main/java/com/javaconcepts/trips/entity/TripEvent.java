package com.javaconcepts.trips.entity;

import com.javaconcepts.trips.EventType;
import com.javaconcepts.trips.TripSummaryRepostiory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static com.javaconcepts.trips.EventType.TRIP_STARTED;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TripEvent {
    private EventType eventType;

    public void applyTo(TripSummary tripSummary, TripSummaryRepostiory tripSummaryRepostiory) {
        eventType.executeEventActionBasedOnCategory(this, tripSummary, tripSummaryRepostiory);
    }
}
