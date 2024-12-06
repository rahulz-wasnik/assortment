package com.javaconcepts.leet.code;

public class L1160FindWordsFormedByGivenChars {

    public static void main(String[] args) {
        System.out.println(countCharacters(new String[]{"cat", "bt", "cac"}, "ctab"));
    }

    public static int countCharacters(String[] words, String chars) {

        int result = 0;

        char store[] = new char[26];

        for (char c: chars.toCharArray()) {
            store[c -'a']++;
        }

        for (String word: words) {

            char storePerWord[] = new char[26];

            for (char c: word.toCharArray()) {
                storePerWord[c -'a']++;
            }

            boolean ok = true;
            for (int i = 0; i < 26; i++) {
                if (storePerWord[i] > store[i]) {
                    ok = false;
                    break;
                }
            }

            if (ok) {
                result += word.length();
            }
        }

        return result;
    }
}

