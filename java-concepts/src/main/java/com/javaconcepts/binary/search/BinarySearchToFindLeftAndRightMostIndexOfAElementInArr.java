package com.javaconcepts.binary.search;

import java.util.concurrent.CompletableFuture;

public class BinarySearchToFindLeftAndRightMostIndexOfAElementInArr {

    static int left_most = 0;
    static int right_most = 0;

    public static void main(String[] args) {

        int[] arr = {1, 3, 3, 3, 3, 4};
        int target = 3;
        int i = 0;
        int j = arr.length - 1;

        lookup(i, j, target, arr, true);
        lookup(i, j, target, arr, false);
        System.out.println(left_most);
        System.out.println(right_most);
    }

    public static int lookup(int i, int j, int target, int arr[], boolean findLeftMost) {
        int mid = 0;
        while (i <= j) {
            mid = (j + i)/2;
            if (target > arr[mid]) {
                i = mid+1;
            } else if (target < arr[mid]) {
                j = mid-1;
            } else {

                if (left_most > mid || left_most == 0) {
                    int x = i;
                    int y = (mid-1);
                    left_most = mid;
                    return lookup(x, y, target, arr, true);
                }

                if (mid > right_most || right_most == 0) {
                    int x = (mid+1);
                    int y = j;
                    right_most = mid;
                    return lookup(x, y, target, arr, false);
                }

            }
        }
        return -1;
    }
}
