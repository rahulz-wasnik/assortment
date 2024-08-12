package com.javaconcepts.leet.code;

public class No9IsPalindrome {

    public static void main(String[] args) {
        System.out.println(isPalindromeNotEfficient(10000001));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        long reversed = 0;
        long temp = x;
        int iterations = 0;

        while (temp != 0) {
            int digit = (int) (temp % 10);
            reversed = reversed * 10 + digit;
            temp /= 10;
            iterations++;
        }

        System.out.println(iterations);
        return (reversed == x);
    }

    public static boolean isPalindromeNotEfficient(int x) {

        int[] arr = String.valueOf(x).chars().map(Character::getNumericValue).toArray();

        int i = 0;
        int j = arr.length - 1;
        int iterationCount = 0;
        boolean isPalindrome = true;

        if (arr.length == 2 && (arr[i] == arr[j])) return true;

        while (i < j) {
            iterationCount++;
            if (arr[i] != arr[j]) {
                isPalindrome = false;
                break;
            }
            i++;
            j--;
        }

        System.out.println(iterationCount);

        return isPalindrome;
    }
}
