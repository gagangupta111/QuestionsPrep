package com.java.questions.high;

import java.util.*;

public class LongestWords {

    public static Set<String> longestWord(String letters, String[] dict) {

        Set<String> finalSet = new LinkedHashSet<>();

        Set<String> outerSet = new LinkedHashSet<>();
        for (int i = 0; i < letters.length(); i++){
            outerSet.add("" + letters.charAt(i));
        }

        for (String s : dict){
            Set<String> innerSet = new LinkedHashSet<>();
            for (int i = 0; i < s.length(); i++){
                innerSet.add("" + s.charAt(i));
            }
            if (outerSet.containsAll(innerSet) && innerSet.containsAll(outerSet)){
                finalSet.add(s);
            }
        }
        return finalSet;
    }

    public static boolean pass() {
        boolean pass = true;

        String[] dict = new String[]{"to", "toe", "toes", "doe", "dog", "god", "dogs", "banana"};
        pass = pass && longestWord("toe", dict).contains("toe");

        dict = new String[]{"abc", "abcd", "acb", "adc", "abcde"};
        pass = pass && longestWord("abc", dict).contains("acb");

        dict = new String[]{"xyz", "x", "y", "z", "xyzxyz"};
        pass = pass && longestWord("xyz", dict).contains("xyzxyz");

        return pass;
    }

    public static void main(String[] args) {
        if(pass()) {
            System.out.println("Pass");
        } else {
            System.err.println("Fails");
        }
    }

}
