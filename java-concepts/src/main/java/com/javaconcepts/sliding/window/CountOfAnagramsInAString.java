package com.javaconcepts.sliding.window;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountOfAnagramsInAString {

    public static void main(String[] args) {

        String target = "aababaabaa";
        String pattern = "aaba";
        Map<String, Long> charsToNoOfTimesTheyOccur = Arrays.stream(pattern.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        int i = 0;
        int j = 0;
        int window_size = pattern.length();
        String[] arr = target.split("");
        int current_window_size = 0;
        int count_of_anagrams = 0;
        Map<String, Long> countOfCharacters = null;
        String[] sub_arr = {};
        
        while(j < arr.length) {
            current_window_size = (j - i + 1);
            if (current_window_size < window_size) {
                j++;
            } else if (current_window_size == window_size) {
                sub_arr = Arrays.copyOfRange(arr, i, (j+1));
                countOfCharacters = Arrays.stream(sub_arr).
                        collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
                boolean anagramFound = countOfCharacters.entrySet().stream().allMatch(e -> {
                            long occurenceCount = Optional.ofNullable(charsToNoOfTimesTheyOccur.get(e.getKey())).orElse(0L);
                            return occurenceCount == e.getValue();
                        });

                if (anagramFound) {
                    count_of_anagrams++;
                }
                i++;
                j++;
            }
        }

        System.out.println("Anagrams found - "+ count_of_anagrams);
    }
}
