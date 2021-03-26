package com.coderpad.answers.low;

import java.util.*;

/**
 *
 *  e.g.
 *      for the input: "abbbccda" the longest uniform substring is "bbb" (which starts at index 1 and is 3 characters long).
 */


public class LongestUniformSubString {

    private static final Map<String, int[]> testCases = new HashMap<String, int[]>();

    static int[] longestUniformSubstring(String input){

        if(input == null || input.length() == 0){
            return new int[]{-1,0};
        }


        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        char c = '-';

        for(int i = 0; i < input.length(); i++){

            if(c == input.charAt(i)){

                count++;

            }else{

                if(map.get(c) == null || map.get(c) < count){

                    map.put(c, count);

                }

                count = 1;
                c = input.charAt(i);

            }
        }

        int max = Integer.MIN_VALUE;
        String maxKey= "";
        String key = "";

        for(Character character : map.keySet()){

            if(map.get(character) > max){

                max = map.get(character);
                key = character.toString();
            }
        }

        for(int i = 0; i < max; i++){

            maxKey += key;

        }

        int index = input.indexOf(maxKey);
        return new int[]{index,maxKey.length()};
    }

    public static void main(String[] args) {

        testCases.put("", new int[]{-1, 0});
        testCases.put("10000111", new int[]{1, 4});
        testCases.put("aabbbbbCdAA", new int[]{2, 5});

        boolean pass = true;
        for(Map.Entry<String,int[]> testCase : testCases.entrySet()){
            int[] result = longestUniformSubstring(testCase.getKey());
            pass = pass && (Arrays.equals(result, testCase.getValue()));
        }
        if(pass){
            System.out.println("Pass!");
        } else {
            System.out.println("Failed! ");
        }
    }
}