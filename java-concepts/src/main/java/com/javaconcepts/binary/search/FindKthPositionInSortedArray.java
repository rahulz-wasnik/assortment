package com.javaconcepts.binary.search;

/**
 * Leetcode: 1539
 */
public class FindKthPositionInSortedArray {

    public static void main(String[] args) {
        int[] arr = {2,3,4,7,11};
        int k = 6;

        int left = 0;
        int right = arr.length;
        int mid = 0;
        int missing_nums = 0;

        while (left < right) {
            mid = (left+right)/2;
            missing_nums = arr[mid] - (mid + 1);

            if (k > missing_nums) {
                left = mid + 1;
            } else {
                right = right - 1;
            }
        }

        System.out.println("missing number - "+ (right+k));
    }

}
