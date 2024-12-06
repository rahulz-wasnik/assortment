package com.javaconcepts.other;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class L242AnagramString {

    public boolean isAnagram(String s, String t) {

        if (s == null || t == null) {
            return false;
        }

        Map<Character, Integer> count = new HashMap<>();

        for (Character c: s.toCharArray()) {
            if (count.containsKey(c)) {
                count.computeIfPresent(c, (k, v) -> ++v);
            } else {
                count.put(c, 1);
            }
        }

        for (Character c: t.toCharArray()) {
            if (count.containsKey(c)) {
                count.computeIfPresent(c, (k, v) -> --v);
            } else {
                count.put(c, 1);
            }
        }

        System.out.println(count);

        return count.values().stream().noneMatch(v -> v < 0 || v > 0);
    }

    public static void main(String[] args) {
        String a = "a";
        String p = "ab";

        L242AnagramString l242AnagramString = new L242AnagramString();
        System.out.println(l242AnagramString.isAnagram(a, p));;
    }
}
