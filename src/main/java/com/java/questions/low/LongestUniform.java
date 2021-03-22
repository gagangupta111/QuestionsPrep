package com.java.questions.low;

import java.util.*;

public class LongestUniform {

    private static final Map<String, int[]> testCases = new HashMap<String, int[]>();

    static int[] longestUniformSubstring(String input){

        int longestStart = -1;
        int longestLength = 0;

        Map<Integer, int[]> map = new HashMap<Integer, int[]>();

        if (input == null || input.length() == 0){
            return new int[]{-1, 0};
        }

        int start = 0;
        int length = 0;
        char c = input.charAt(0);

        for (int i = 0; i < input.length(); i++){

            if (c == input.charAt(i)){
                length++;
                continue;
            }else {

                map.put(length, new int[]{start, length});

                // reset
                start = i;
                c = input.charAt(i);
                length = 0;
                i--;

                continue;


            }

        }
        map.put(length, new int[]{start, length});

        LinkedList<Integer> list = new LinkedList<Integer>(map.keySet());
        Collections.sort(list, Collections.<Integer>reverseOrder());

        return map.get(list.get(0));
        // your code goes here

    }

    public static void main(String[] args) {

        testCases.put("", new int[]{-1, 0});
        testCases.put(null, new int[]{-1, 0});
        testCases.put("10000111", new int[]{1, 4});
        testCases.put("111112222222444444666666666", new int[]{18, 9});
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
