package com.javaconcepts.binary.search;

import java.util.Arrays;

public class FindMinimumInRotatedSortedArray {

    public static void main(String[] args) {
        int[] arr = new int[]{3,4,5,1,2};
        int target = 4;
        int l = 0;
        int r = arr.length - 1;
        int mid = 0;

        while(l < r) {
            mid = (l+r)/2;
            if (arr[mid] > arr[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        int pivot_index = r;
        // Searching left side of pivot index
        binarySearch(0, pivot_index - 1, target, arr);
        // Searching right side of pivot index
        binarySearch(pivot_index + 1, arr.length - 1, target, arr);
    }

    public static void binarySearch(int left, int right, int target, int[] arr) {
        int mid = 0;
        while (left <= right) {
            mid = (right + left)/2;
            if (target > arr[mid]) {
                left = mid+1;
            } else if (target < arr[mid]) {
                right = mid-1;
            } else {
                System.out.println(target + " found at index "+ mid);
                break;
            }
        }
    }
}
