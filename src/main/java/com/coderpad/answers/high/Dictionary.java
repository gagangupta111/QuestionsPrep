package com.coderpad.answers.high;

//     Given a a string of letters and a dictionary, the function longestWord should
//     find the longest word or words in the dictionary that can be made from the letters
//     Input: letters = "oet", dictionary = {"to","toe","toes", "toetoe"}
//     Output: {"toetoe"}

import java.util.*;

public class Dictionary {
    private String[] entries;

    public Dictionary(String[] entries) {
        this.entries = entries;
    }

    public boolean contains(String word) {
        return Arrays.asList(entries).contains(word);
    }
}

class Solution {

    public static Set<String> longestWord(String letters, String[] list) {

        String longest = "";
        Set<String> finalSet = new LinkedHashSet<>();
        Set<Character> set1 = new LinkedHashSet<>();

        for (int i = 0 ; i < letters.length(); i++){

            set1.add(letters.charAt(i));

        }


        for (String word : list){


            Set<Character> set2 = new LinkedHashSet<>();
            for (int i = 0 ; i < word.length(); i++){

                set2.add(word.charAt(i));

            }

            if (set1.containsAll(set2) && set2.containsAll(set1)){
                finalSet.add(word);
            }


        }

        return finalSet;

    }


    public static boolean pass() {

        String[] dict = new String[]{"to", "toe", "toes", "toetoe", "doe", "dog", "god", "dogs", "banana"};
        boolean r = new HashSet<String>(Arrays.asList("toe", "toetoe")).equals(longestWord("toetoe", dict));
        return r;
    }

    public static void main(String[] args) {
        if(pass()) {
            System.out.println("Pass");
        } else {
            System.err.println("Fails");
        }
    }
}