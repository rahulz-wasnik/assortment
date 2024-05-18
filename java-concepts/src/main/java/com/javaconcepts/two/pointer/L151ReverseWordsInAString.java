package com.javaconcepts.two.pointer;

public class L151ReverseWordsInAString {

    public static String reverseWords(String s) {

        if(s == null) return null;

        String result = null;
        int i = 0;
        int j = 0;
        int length = s.length();
        String subString = "";

        while (i < length) {

            while (i < length && s.charAt(i) == ' ') {
                i++;
            }

            if (i >= length) break;

            j = i + 1;

            while (j < length && s.charAt(j) != ' ') {
                j++;
            }

            subString = s.substring(i, j);

            result = result == null ? subString : subString + " " + result;

            i = j;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("   hello world ").length());
    }
}
