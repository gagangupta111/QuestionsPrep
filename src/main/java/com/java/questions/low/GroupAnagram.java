package com.java.questions.low;

import java.util.*;

public class GroupAnagram {

    static String input = "cat dog tac sat tas god dog";

    static void setOfAnagrams(String inputString){

        //your code goes here
        Set<String> anagrams = new LinkedHashSet<>();
        List<String> all = new LinkedList<>(Arrays.asList(inputString.split(" ")));

        LinkedHashSet<Integer> set = new LinkedHashSet<>();

        while (all.size() > 0){

            String one = all.get(0);
            for (String s : all){
                if (isAnagram(one, s)){
                    anagrams.add(s);
                }
            }

            all.removeAll(anagrams);
        }

        System.out.println(anagrams);
    }

    public static boolean isAnagram(String one, String two){

        if (one == null && two == null){
            return true;
        }

        if (one == null || two == null){
            return false;
        }

        if (one.length() != two.length()){
            return false;
        }

        List<Integer> oneArray = new ArrayList<>();
        List<Integer> twoArray = new ArrayList<>();

        for (char c : one.toCharArray()){
            oneArray.add(Integer.valueOf(c));
        }

        for (char c : two.toCharArray()){
            twoArray.add(Integer.valueOf(c));
        }

        Collections.sort(oneArray);
        Collections.sort(twoArray);

        for (int i = 0; i < oneArray.size() ; i++){
            if (oneArray.get(i) != twoArray.get(i)){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        String input = "cat dog tac sat tas god dog gsjg sjhgh jhsgd";
        setOfAnagrams(input);

    }

}

