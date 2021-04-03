package com.coderpad.answers.low;

public class LongestUniformString {


    public static void main(String[] args){

        System.out.println("========");
        System.out.println(longest("ggggaabbbcccgg"));

    }


    public static String longest(String input){

        if (input == null || input.length() == 0){

            return null;

        }

        int maxLength = Integer.MIN_VALUE;
        String longestSubString = "";

        int tempLength = 0;
        String tempSubString = "";

        Character character = input.charAt(0);
        tempSubString += character + "";
        tempLength = 1;

        for (int i = 1; i < input.length(); i++){

            if (character == input.charAt(i)){

                tempSubString += input.charAt(i) + "";
                tempLength++;

            }else {

                if (tempLength > maxLength){
                    maxLength = tempLength;
                    longestSubString = tempSubString;

                }

                character = input.charAt(i);
                tempSubString = character + "";
                tempLength = 1;

            }

        }

        if (tempLength > maxLength){
            maxLength = tempLength;
            longestSubString = tempSubString;

        }

        return longestSubString;


    }


}
