package com.javaconcepts.leet.code;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class No13RomanToInt {

    public static void main(String[] args) {
        System.out.println("Final - "+romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {
        Map<Character, Integer> m = new HashMap<>();

        m.put('I', 1);
        m.put('V', 5);
        m.put('X', 10);
        m.put('L', 50);
        m.put('C', 100);
        m.put('D', 500);
        m.put('M', 1000);

        if (Objects.isNull(s) || s.length() == 0) {
            return 0;
        }

        char[] arr = s.toCharArray();
        int value = 0;

        if (s.length() == 1) {
            return m.get(arr[0]);
        }

        for (int i = 0; i <= (arr.length - 1); i++) {

            // IV
            if (i < s.length() - 1 && m.get(arr[i]) < m.get(arr[i + 1])) {
                value -= m.get(arr[i]);
            } else {
                value += m.get(arr[i]);
            }
        }
        return value;
    }
}
