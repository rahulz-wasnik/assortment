package com.javaconcepts.leet.code;

import java.util.Arrays;

public class L189RotateArray {

    public void rotate(int[] nums, int k) {

        int n = nums.length;
        k = k % n;
        int[] rotated = new int[n];

        for (int i = 0; i < n; i++) {
            rotated[(i + k) % n] = nums[i];
        }

        for (int i = 0; i < n; i++) {
            nums[i] = rotated[i];
        }

        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        L189RotateArray l189RotateArray = new L189RotateArray();
        l189RotateArray.rotate(new int[]{1,2,3,4,5,6,7}, 9);

    }
}
