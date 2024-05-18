package com.javaconcepts.binary.search;

public class BinarySearch {

    public static void main(String[] args) {

        int[] arr = {1, 3, 4, 7, 8};
        int target = 9;
        int i = 0;
        int j = arr.length - 1;
        int mid = 0;

        while (i <= j) {
            mid = (j + i)/2;
            if (target > arr[mid]) {
                i = mid+1;
            } else if (target < arr[mid]) {
                j = mid-1;
            } else {
                System.out.println(target + " found at index "+ mid);
                break;
            }
        }
    }
}
