package com.javaconcepts.leet.code;

public class L1464MaximumProductofTwoElementsInAnArray {

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{3,4,5,2}));
    }

    public static int maxProduct(int nums[]) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int largest = 0;
        int second_largest = 0;

        for (int i = 0; i < nums.length; i++) {
           if (nums[i] > largest) {
               second_largest = largest;
               largest = nums[i];
           } else {
               second_largest = Math.max(second_largest, nums[i]);
           }
        }

        return (largest - 1) * (second_largest - 1);
    }
}
