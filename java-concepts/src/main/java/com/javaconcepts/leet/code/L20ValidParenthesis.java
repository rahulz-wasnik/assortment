package com.javaconcepts.leet.code;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class L20ValidParenthesis {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        int i = 0;

        if (s == null || s.length() == 0 || s.length() == 1) return false;

        while (i < s.length()) {

            if (s.charAt(i) == '(') {
                stack.push(')');
            } else if (s.charAt(i) == '{') {
                stack.push('}');
            } else if (s.charAt(i) == '[') {
                stack.push(']');
            } else if (s.charAt(i) == ')') {
                if (stack.empty() || stack.pop() != ')') {
                    return false;
                };
            } else if (s.charAt(i) == '}') {
                if (stack.empty() || stack.pop() != '}') {
                    return false;
                };
            } else if (s.charAt(i) == ']') {
                if (stack.empty() || stack.pop() != ']') {
                    return false;
                };
            }

            i++;
        }

        return stack.empty();
    }

    public static void main(String[] args) {
        String s = "){";
        L20ValidParenthesis obj = new L20ValidParenthesis();
        System.out.println(obj.isValid(s));
    }
}
