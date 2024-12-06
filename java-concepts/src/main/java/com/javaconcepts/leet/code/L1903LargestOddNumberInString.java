package com.javaconcepts.leet.code;

public class L1903LargestOddNumberInString {

    public static void main(String[] args) {
        String num = "32564786";
        String result = "";
        for (int i = num.length() - 1; i >= 0; i--) {
            if (Character.getNumericValue(num.charAt(i)) % 2 != 0) {
                result = num.substring(0, i+1);
                break;
            }
        }
        System.out.println(result);
    }
}
