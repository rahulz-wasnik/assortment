package com.javaconcepts.binary.search;

/**
 * Example in arr 5, 1, 2, 3, 4 the min rotation count is 1 since by moving '1' backwards by 1 step
 * to the 0th index the arr becomes a sorted array
 */

public class FindMinRotationCountInSortedArray {

    public static void main(String[] args) {
        int[] arr = new int[]{5,1,2,3,4};

        int left = 0;
        int right = arr.length - 1;
        int mid = 0;

        while (left < right) {
            mid = (left + right)/2;

            if (arr[mid] > arr[right]) {
                left = mid+1;
            } else {
                right = mid;
            }
        }

        System.out.println("Rotation count - "+right);
    }
}
