package com.javaconcepts.two.pointer;

import java.util.Arrays;
import java.util.Objects;

public class L26RemoveDuplicatesFromArray {

    public static int removeDuplicates(int[] nums) {

        if (Objects.isNull(nums) || nums.length == 0) {
            return -1;
        }

        if (nums.length == 1) {
            return 1;
        }

        int i = 0;
        int j = 1;

        while (j < nums.length) {

            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }

            j++;
        }
        System.out.println(Arrays.toString(nums));
        return i+1;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
    }
}
