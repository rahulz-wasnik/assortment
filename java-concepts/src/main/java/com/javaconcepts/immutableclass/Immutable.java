package com.javaconcepts.immutableclass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Immutable {

    private final String name;

    private final List<String> reviews;

    public Immutable(String name, List<String> reviews) {
        this.name = name;
		this.reviews = new ArrayList<>(reviews);
    }

    public String getName() {
        return name;
    }

    public List<String> getReviews() {
        return new ArrayList<>(reviews);
    }
}
