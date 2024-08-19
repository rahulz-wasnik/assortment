package com.javaconcepts.leet.code.strings;

public class L443StringCompression {

    public int compress(char[] chars) {

        if (chars == null || chars.length == 0) {
            return 0;
        }

        if (chars.length == 1) {
            return 1;
        }

        int i = 0;
        int j = 0;
        while (j < chars.length) {
            int count = 0;
            char curr = chars[j];

            while (j < chars.length && chars[j] == curr) {
                j++;
                count++;
            }
            chars[i++] = curr;
            if (count > 1) {
                for (char digit : Integer.toString(count).toCharArray()) {
                    chars[i++] = digit;
                }
            }
        }
        return i;
    }

    public static void main(String[] args) {
        L443StringCompression l443StringCompression = new L443StringCompression();
        System.out.println(l443StringCompression.compress(new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'}));;
    }
}
