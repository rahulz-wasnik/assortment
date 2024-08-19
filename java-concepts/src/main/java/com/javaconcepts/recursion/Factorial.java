package com.javaconcepts.recursion;

import java.util.HashSet;
import java.util.Set;

public class Factorial {

    public int compute(int num) {
        if (num == 1) {
            return num;
        }

        return num * compute(num -1);
    }

    public static void main(String[] args) {
        Factorial factorial = new Factorial();
        System.out.println(factorial.compute(5));
    }
}
