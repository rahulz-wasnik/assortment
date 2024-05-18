package com.javaconcepts.sliding.window;

import java.util.Arrays;

public class FirstNegativeNumberInEverySubArray {

    static int[] arr = new int[]{12, -1, -7, 8, -15, 30, 16, 28};
    static int window_size = 3;

    public static void main(String[] args) {

        int i = 0;
        int j = 0;
        int[] sub_arr = new int[]{};
        int current_window_size = 0;


        while (j < arr.length) {
            current_window_size = (j - i + 1);

            if (current_window_size < window_size) {
                j++;
            } else if (current_window_size == window_size) {

                sub_arr = Arrays.copyOfRange(arr, i, (j+1));
                // extract first negative number from the window size
                for (int e: sub_arr) {
                    if (e < 0) {
                        System.out.println("Min number found - "+e);
                        break;
                    }
                }

                i++;
                j++;
            }
        }
    }
}
