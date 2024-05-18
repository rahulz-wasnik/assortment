package com.javaconcepts.leet.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static List<List<Integer>> findCombinationOfThreeWhichAddsUpToTarget(
            int[] arr, int target, int l, int r
    ) {

        List<List<Integer>> combinations = new ArrayList<>();

        while (l < r) {

            if (arr[l] + arr[r] > target) {
                r--;
            } else if (arr[l] + arr[r] < target) {
                l++;
            } else {
                while (l < r && arr[l] == arr[l+1]) {
                    l++;
                }

                while (l < r && arr[r] == arr[r-1]) {
                    r--;
                }
                List<Integer> combination = new ArrayList<>();
                combination.add(target);
                combination.add(arr[l]);
                combination.add(arr[r]);
                System.out.println(combination);
                combinations.add(combination);
                l++;
                r--;
            }
        }

        return combinations;
    }

    public static void main(String[] args) {

        int[] arr = {-1,0,1,2,-1,-4};

        Arrays.sort(arr);

        int target = 0;

        for (int i = 0; i < arr.length - 2; i++) {

            if (i > 0 && arr[i] == arr[i-1]) {
                continue;
            }

            target = -(arr[i]);

            findCombinationOfThreeWhichAddsUpToTarget(arr, target, i+1, (arr.length - 1));
        }
    }


}
