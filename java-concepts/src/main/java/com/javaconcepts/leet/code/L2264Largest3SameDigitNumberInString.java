package com.javaconcepts.leet.code;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class L2264Largest3SameDigitNumberInString {

    public static void main(String[] args) {
        System.out.println(nonJava8("677719993"));
    }

    public static String nonJava8(String target) {

        Integer targetArr[] = Stream.of(target.split("")).map(Integer::parseInt).toArray(Integer[]::new);
        int max = 0;
        for(int i = 2; i < targetArr.length; i++) {
            if (targetArr[i] == targetArr[i-1] && targetArr[i] == targetArr[i-2]) {
                max = Math.max(max, targetArr[i]);
            }
        }

        return new String(Integer.toString(max) + Integer.toString(max) + Integer.toString(max));
    }

    public static void useJava8() {
        String target = "677719993";

        Optional<Integer> first = Stream.of(target.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 3)
                .map(entry -> Integer.valueOf(entry.getKey()))
                .sorted((a, b) -> b - a)
                .findFirst();

        System.out.println(first.get());
    }
}
