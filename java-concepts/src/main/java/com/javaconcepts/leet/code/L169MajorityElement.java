package com.javaconcepts.leet.code;

import java.util.HashMap;
import java.util.Map;

public class L169MajorityElement {

    public int majorityElement(int[] nums) {

        if (nums == null) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int count = nums.length/2;
        int element = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(nums[i])) {
                map.computeIfPresent(nums[i], (k,v) ->  v + 1);
                if (map.get(nums[i]) > count) {
                    element = nums[i];
                    break;
                }

            } else {
                map.put(nums[i], 1);
            }
        }

        return element;
    }

    public static void main(String[] args) {
        L169MajorityElement l169MajorityElement = new L169MajorityElement();
        System.out.println(l169MajorityElement.majorityElement(new int[]{3,2,3}));;
    }
}
