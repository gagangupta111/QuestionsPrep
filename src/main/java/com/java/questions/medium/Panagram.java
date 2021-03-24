package com.java.questions.medium;

import java.util.LinkedHashSet;
import java.util.Set;

public class Panagram {

    private static class PanagramDetector {
        private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

        public String findMissingLetters(String sentence) {

            String finalString = "";
            sentence = sentence.toLowerCase();
            Set<Character> characters = new LinkedHashSet<>();

            for (int i = 97 ; i <= 122; i++){
                characters.add(((char) i));
            }

            for (int i = 0 ; i < sentence.length(); i++){
                characters.remove(sentence.charAt(i));
            }

            for (char c : characters){
                finalString += c;
            }

            return finalString;

        }

    }

    public static void main(String[] args) {
        PanagramDetector pd = new PanagramDetector();
        boolean success = true;

        success = success && "".equals(pd.findMissingLetters("The quick brown fox jumps over the lazy dog"));
        success = success && "abcdefghijklmnopqrstuvwxyz".equals(pd.findMissingLetters(""));

        if (success) {
            System.out.println("Pass ");
        } else {
            System.out.println("Failed");
        }
    }

}
