package com.javaconcepts.other;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

public class FindIndexOfFirstUniqueElementInStringOrReturnMinusOneIfThereAreNone {

    public static void main(String[] args) {
        String s = "googll";
        System.out.println(getIndexOfFirstUniqueElement(s));;
    }

    public static int getIndexOfFirstUniqueElement(String s) {
        String[] split = s.split("");
        Map<String, Integer> uniqueElement = new HashMap<>();
        for (int i = 0; i< split.length; i++) {

            if (uniqueElement.containsKey(split[i])) {
                uniqueElement.remove(split[i]);
            } else {
                uniqueElement.put(split[i], i);
            }

        }

        return uniqueElement.values().stream().sorted().findFirst().orElse(-1);
    }
}