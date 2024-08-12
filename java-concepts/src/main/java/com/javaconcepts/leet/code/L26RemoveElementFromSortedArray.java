package com.javaconcepts.leet.code;

import java.util.Arrays;

public class L26RemoveElementFromSortedArray {

    public static void main(String[] args) {

        int nums[] = {1, 2, 3, 3, 3, 4, 5, 5, 5, 6};

        int j = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[j] = nums[i];
                j++;
            }
            System.out.println(Arrays.toString(nums));
        }
        System.out.println(Arrays.toString(nums));
    }
}
