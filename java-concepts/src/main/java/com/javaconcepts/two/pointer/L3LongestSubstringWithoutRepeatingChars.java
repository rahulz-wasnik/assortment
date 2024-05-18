package com.javaconcepts.two.pointer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class L3LongestSubstringWithoutRepeatingChars {

    public static void main(String[] args) {
        String s = "abcabcbb";
        String[] arr = s.split("");

        int i = 0;
        int j = 0;
        int max_length = 0;

        Map<String, Integer> charIndexMap = new HashMap<>();

        while (j < arr.length) {

            if (!charIndexMap.containsKey(arr[j])) {
                charIndexMap.put(arr[j], j);
                max_length = Math.max(max_length, (j - i + 1));
            } else {
                while (charIndexMap.containsKey(arr[j])) {
                    charIndexMap.remove(arr[i]);
                    i++;
                }
                charIndexMap.put(arr[j], j);
            }

            j++;
        }

        System.out.println(max_length);

    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        Set<Character> charSet = new HashSet<>();
        int left = 0;

        for (int right = 0; right < n; right++) {
            if (!charSet.contains(s.charAt(right))) {
                charSet.add(s.charAt(right));
                maxLength = Math.max(maxLength, right - left + 1);
            } else {
                while (charSet.contains(s.charAt(right))) {
                    charSet.remove(s.charAt(left));
                    left++;
                }
                charSet.add(s.charAt(right));
            }
        }

        return maxLength;
    }
}
