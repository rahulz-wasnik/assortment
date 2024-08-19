package com.javaconcepts.recursion;

public class PrintAStringInReverse {

    public String compute(String str, int index) {

        if (index < str.length()-1) {
            return compute(str, (index+1)) + str.charAt(index);
        }

        return String.valueOf(str.charAt(index));
    }

    public static void main(String[] args) {
        PrintAStringInReverse printAStringInReverse = new PrintAStringInReverse();
        System.out.println(printAStringInReverse.compute("abc", 0));
    }
}
