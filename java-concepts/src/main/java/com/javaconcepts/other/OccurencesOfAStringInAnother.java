package com.javaconcepts.other;

public class OccurencesOfAStringInAnother {

    private String[] target = "aabaaba".split("");
    private final String[] pattern = "aaba".split("");
    private final int[] lps = new int[pattern.length];

    public void calculateLps() {
        int length = 0;
        int i = 0;
        lps[0] = length;
        int pattern_length = pattern.length;

        while (i < pattern_length) {
            if (pattern[i] == pattern[length]) {
                lps[i] = ++length;
            } else {
                if (length > 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                }
            }
            i++;
        }
    }

    public void printLps() {
        System.out.println();
        for (int i: lps) System.out.print(i + "");
        System.out.println();
    }

    public int match(int i, int j) {

        if (i == (target.length - 1)) {
            if (target[i].equalsIgnoreCase(pattern[j])) {
                System.out.println("Match found at - " + (i - j));
            }
            System.out.println("Pattern matching completed");
            return -1;
        }

        if (j == pattern.length - 1) {
            System.out.println("Match found at - " + (i - j));
            i++;
            j = 0;
        } else if (target[i].equalsIgnoreCase(pattern[j])) {
            i++;
            j++;
        } else {
            i++;
        }

        return match(i,j);
    }

    public static void main(String[] args) {

        OccurencesOfAStringInAnother occurencesOfAStringInAnother = new OccurencesOfAStringInAnother();
        occurencesOfAStringInAnother.calculateLps();
        occurencesOfAStringInAnother.printLps();
        occurencesOfAStringInAnother.match(0, 0);

    }
}
