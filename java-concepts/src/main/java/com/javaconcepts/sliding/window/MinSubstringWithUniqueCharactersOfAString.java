package com.javaconcepts.sliding.window;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class MinSubstringWithUniqueCharactersOfAString {

    public static int shortestSubstringLength(String s) {

        String[] target = s.split("");
        int totalNoOfUnique = Arrays.stream(target).collect(Collectors.toSet()).size();

        // min length of a substring with all unique characters
        int min_length = 0;

        int i = 0;
        int j = 0;
        int countOfUnique = 0;
        String[] subArray = null;
        int siling_window_size = 0;

        while (j < target.length) {

            subArray = Arrays.copyOfRange(target, i, (j+1));
            countOfUnique =  Arrays.stream(subArray).collect(Collectors.toSet()).size();

            if (countOfUnique < totalNoOfUnique) {
                j++;
            } else if (countOfUnique == totalNoOfUnique) {
                while(countOfUnique == totalNoOfUnique) {
                    siling_window_size = j - i + 1;
                    min_length = min_length == 0 ? siling_window_size : Math.min(min_length, siling_window_size);
                    i++;
                    subArray = Arrays.copyOfRange(target, i, (j+1));
                    countOfUnique =  Arrays.stream(subArray).collect(Collectors.toSet()).size();
                }

                j++;
            }
        }


        return min_length;
    }

    public static void main(String[] args) {
        String input = "abcceabc";
        System.out.println(shortestSubstringLength(input));
    }
}
