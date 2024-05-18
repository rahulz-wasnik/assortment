package com.javaconcepts.union.find;

import java.util.Arrays;

public class UnionFind {

    static int[] arr = new int[10];

    public static void main(String[] args) {

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        System.out.println(Arrays.toString(arr));
        union(1,2);
        union(1,7);
        System.out.println(Arrays.toString(arr));
    }

    public static boolean isConnected(int p, int q) {
        return arr[p] == arr[q];
    }

    public static void union(int p, int q) {

        int pVal = arr[p];
        int qVal = arr[q];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == pVal) arr[i] = qVal;
        }
    }
}
