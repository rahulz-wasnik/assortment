package com.javaconcepts.two.pointer;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class L345ReverseVowelsInAString {

    public static void main(String[] args) {
        System.out.println(reverseVowels("hello"));
    }

    public static String reverseVowels(String str) {

        if (Objects.isNull(str) || (str.length() == 0)) {
            return null;
        }

        char[] arr = str.toCharArray();
        int i = 0;
        int j = (arr.length - 1);
        char temp = '0';

        while (i < j) {

            while (i < j && !isVowel(arr[i])) i++;

            while (i < j && !isVowel(arr[j])) j--;

            if (isVowel(arr[i]) == isVowel(arr[j])) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        return String.valueOf(arr);
    }


    public static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
