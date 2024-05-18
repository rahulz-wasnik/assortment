package com.javaconcepts.other;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindPairsOfNumbersInAListWhichAddTo12 {

    public static void findPairs(List<Integer> numbers, int targetSum) {
        Set<Integer> seenNumbers = new HashSet<>();

        for (Integer num : numbers) {
            int complement = targetSum - num;

            if (seenNumbers.contains(complement)) {
                System.out.println("Pair found: (" + num + ", " + complement + ")");
            }

            seenNumbers.add(num);
        }
    }

    public static void main(String[] args) {
        List<Integer> numberList = List.of(1,3,7,5,8,9,4);
        int targetSum = 12;

        findPairs(numberList, targetSum);
    }
}
