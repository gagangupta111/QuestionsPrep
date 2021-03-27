package com.coderpad.answers.low;


import java.io.*;
        import java.util.*;

/*
 * This program prints set of anagrams together in given string
 *
 * eg.
 * setOfAnagrams("cat dog tac sat tas god dog") should print "cat tac dog god dog sat tas"
 *
 */

class GroupAnagrams {

    static String input = "cat dog tac sat tas god dog";

    static void setOfAnagrams(String inputString){

        List<String> initialSet = new ArrayList<>();
        Set<String> finalSet = new LinkedHashSet<>();

        String[] split = inputString.split(" ");


        for(String string : split){
            initialSet.add(string);
        }

        while(!initialSet.isEmpty()){

            String first = initialSet.get(0);

            Set<String> tempSet = new LinkedHashSet<>();
            tempSet.add(first);

            for(int i = 1; i < initialSet.size(); i++){

                if(ifAnagram(first, initialSet.get(i))){
                    tempSet.add(initialSet.get(i));
                }

            }

            initialSet.removeAll(tempSet);
            finalSet.addAll(tempSet);

        }

        //your code goes here
        String finalString  = "";
        for(String string : finalSet){
            finalString += string + " ";
        }

        System.out.println(finalString.trim());


    }

    public static boolean ifAnagram(String one, String two){

        if(one == null && two == null){
            return true;
        }

        if(one == null || two == null){
            return false;
        }

        if(one.length() != two.length()){
            return false;
        }

        Set<String> oneSet = new HashSet<>();
        Set<String> twoSet = new HashSet<>();


        for(String character : one.split("")){

            oneSet.add(character);

        }



        for(String character : two.split("")){

            twoSet.add(character);

        }

        if(oneSet.containsAll(twoSet) && twoSet.containsAll(oneSet)){
            return true;
        }else{
            return false;
        }


    }


    public static void main(String[] args) {

        String input = "cat dog tac sat tas god dog";
        setOfAnagrams(input);

    }
}
