package com.javaconcepts.two.pointer;

public class L209MinSubarraySizeSum {

    public int minSubArrayLen(int target, int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int left = 0;
        int right = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        while (right < nums.length) {
            sum += nums[right];

            while (sum >= target) {
                minLength = Math.min((right - left + 1), minLength);
                sum -= nums[left];
                left++;
            }
            right++;
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
        L209MinSubarraySizeSum l209MinSubarraySizeSum = new L209MinSubarraySizeSum();
        System.out.println(l209MinSubarraySizeSum.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        ;
    }
}
