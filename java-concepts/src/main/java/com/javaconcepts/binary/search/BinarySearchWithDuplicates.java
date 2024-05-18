package com.javaconcepts.binary.search;

public class BinarySearchWithDuplicates {

    public static void main(String[] args) {

        int[] arr = {1, 1, 3, 3, 4, 4, 7, 7, 8, 8};
        int target = 8;
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;

        while (left <= right) {

            while(left < right && (arr[left] == (arr[left+1]))) {
                left++;
            }

            while(left < right && (arr[right] == (arr[right-1]))) {
                right--;
            }

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
