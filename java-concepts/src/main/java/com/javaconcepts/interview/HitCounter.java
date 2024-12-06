package com.javaconcepts.interview;

import java.util.LinkedList;
import java.util.Queue;

/*
     Design a hit counter which counts the number of hits received in the past 5 minutes.
	 Each function accepts a timestamp parameter (in seconds granularity)
	 and you may assume that calls are being made to the system in chronological
	 order (ie, the timestamp is monotonically increasing). You may assume that the earliest timestamp starts at 1.
	 It is possible that several hits arrive roughly at the same time.
*/
public class HitCounter {
    // Queue to store the timestamp and the number of hits at each timestamp
    private Queue<int[]> hits;
    private final int TIME_WINDOW = 300; // 5 minutes = 300 seconds

    /**
     * Initialize the hit counter.
     */
    public HitCounter() {
        hits = new LinkedList<>();
    }

    /**
     * Record a hit.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public void hit(int timestamp) {
        // If the hit is at the same timestamp as the last one, we simply increment the count
        if (!hits.isEmpty() && hits.peek()[0] == timestamp) {
            hits.peek()[1]++;
        } else {
            // Otherwise, we add a new entry with the current timestamp and 1 hit
            hits.offer(new int[]{timestamp, 1});
        }

        // Remove outdated hits that are older than 5 minutes
        removeOldHits(timestamp);
    }

    /**
     * Return the number of hits in the past 5 minutes.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     * @return The number of hits in the past 5 minutes.
     */
    public int getHits(int timestamp) {
        // Remove outdated hits before counting
        removeOldHits(timestamp);

        int totalHits = 0;
        // Sum the hits within the last 5 minutes
        for (int[] hit : hits) {
            totalHits += hit[1];
        }

        return totalHits;
    }

    /**
     * Helper function to remove hits that are older than 5 minutes
     */
    private void removeOldHits(int currentTime) {
        while (!hits.isEmpty() && currentTime - hits.peek()[0] >= TIME_WINDOW) {
            hits.poll(); // Remove the hit at the front of the queue
        }
    }
}
