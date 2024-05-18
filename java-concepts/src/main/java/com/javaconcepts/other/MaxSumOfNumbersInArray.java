package com.javaconcepts.other;

public class MaxSumOfNumbersInArray {

    public static void main(String[] args){
        int arr[] = { 1, 4, 2, 10, 2, 3, 1, 0, 20 };

        int k = 4;

        int max_sum = 0;

        for (int i = 0; i < k; i++) {
            max_sum = max_sum + arr[i];
        }

        int window_sum = max_sum;

        for (int i = k; i < arr.length; i++) {
            window_sum = window_sum - arr[i - k] + arr[i];
            max_sum = Math.max(max_sum, window_sum);
        }

        System.out.println(max_sum);
    }
}
