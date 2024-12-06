package com.javaconcepts.leet.code;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L1436DestinationCity {

    public static void main(String[] args) {

    }

    public String destCity(List<List<String>> paths) {

        if (paths == null || paths.size() == 0) {
            return null;
        }

        Set<String> city = new HashSet<>();

        for (List<String> path: paths) {
            city.add(path.get(0));
        }

        for (List<String> path: paths) {
            if (!city.contains(path.get(1))) {
                return path.get(1);
            }
        }

        return null;
    }
}
