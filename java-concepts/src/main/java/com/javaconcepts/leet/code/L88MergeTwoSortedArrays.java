package com.javaconcepts.leet.code;

import java.util.Arrays;

public class L88MergeTwoSortedArrays {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        if (nums1.length == 0 || nums2.length == 0) {
            return;
        }

        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
    }

    public static void main(String[] args) {

        L88MergeTwoSortedArrays l88MergeTwoSortedArrays = new L88MergeTwoSortedArrays();
        l88MergeTwoSortedArrays.merge(new int[]{4,5,6,0,0,0}, 3, new int[]{1,2,3}, 3);

    }
}
