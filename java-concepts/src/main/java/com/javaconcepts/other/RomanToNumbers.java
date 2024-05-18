package com.javaconcepts.other;

import java.util.HashMap;
import java.util.Map;

public class RomanToNumbers {

    public static void main(String[] args) {
        // 27 XXVII
        // 1034 MXXXIV
        // 634 DCXXXIV

        String roman = "MCMXCIV";  //1994

        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int result = 0;
        int prevValue = 0;

        for (int i = roman.length() - 1; i >= 0; i--) {
            int value = romanMap.get(roman.charAt(i));
            if (value < prevValue) {
                result -= value;
            } else {
                result += value;
            }
            prevValue = value;
        }
        System.out.println(result);
    }
}
