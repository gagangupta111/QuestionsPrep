package com.coderpad.answers.low;

/*
 * Implement a run length encoding function.
 * For a string input the function returns output encoded as follows:
 *
 * "a"     -> "a1"
 * "aa"    -> "a2"
 * "aabbb" -> "a2b3"
 * "aaabbbaaabb" --> ??
 */
public class lengthEncoding {

    public static String rle(String input) {


        String result = "";
        if(input == null ){

            throw new IllegalArgumentException("Illegal Inout");

        }

        if (input.length() == 0){
            return input;
        }

        Character c = input.charAt(0);
        int length = 1;

        for (int i = 1; i < input.length(); i ++){

            if (input.charAt(i) == c){
                length++;
            }else {

                result += c + String.valueOf(length);
                length = 1;
                c = input.charAt(i);

            }

        }

        // Your code goes here
        result += c + String.valueOf(length);
        return result;
    }


    public static void main(String[] args)  {

        if("".equals(rle("")) &&
                "a1".equals(rle("a")) &&
                "a3b2a2".equals(rle("aaabbaa")) &&
                "a3".equals(rle("aaa"))){
            System.out.println("Passed");
        }else {
            System.out.println("Failed");
        }
    }
}