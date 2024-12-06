package com.javaconcepts.leet.code.strings;

public class L3110ScoreOfString {

    public int scoreOfString(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        int i = 1;
        int diff = 0;
        int score = 0;

        while(i < s.length()) {
            diff = ((int) s.charAt(i-1)) - ((int) s.charAt(i));
            score = score + ((diff < 0) ? -(diff) : diff);
            i++;
        }

        return score;
    }

    public static void main(String[] args) {
        L3110ScoreOfString l3110ScoreOfString = new L3110ScoreOfString();
        System.out.println(l3110ScoreOfString.scoreOfString("hello"));
    }
}
