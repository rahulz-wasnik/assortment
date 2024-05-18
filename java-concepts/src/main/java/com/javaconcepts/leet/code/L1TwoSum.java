package com.javaconcepts.leet.code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class L1TwoSum {

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        int diff = 0;
        int i = 0;
        int[] two_sum = new int [2];

        while (i < nums.length) {

            diff = target - nums[i];

            if (!map.containsKey(diff)) {
                map.put(nums[i], i);
            } else {
                two_sum[0] = map.get(diff);
                two_sum[1] = i;
                break;
            }

            i++;
        }

        return two_sum;
    }

    public static void main(String[] args) {

        L1TwoSum l1TwoSum = new L1TwoSum();
        System.out.println(Arrays.toString(l1TwoSum.twoSum(new int[]{2,7,11,15}, 9)));
    }
}
