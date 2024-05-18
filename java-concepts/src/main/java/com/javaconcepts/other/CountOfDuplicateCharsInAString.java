package com.javaconcepts.other;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountOfDuplicateCharsInAString {

    public static void main(String[] args) {
        Map<String, Long> collect = Arrays.stream("malyalam".split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(s -> s.getValue() > 1).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println(collect);
    }
}
