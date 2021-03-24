package com.java.questions.low;

/*
 * Implement a run length encoding function.
 * For a string input the function returns output encoded as follows:
 *
 * "a"     -> "a1"
 * "aa"    -> "a2"
 * "aabbb" -> "a2b3"
 * "aaabbbaaabb" --> ??
 */

import java.util.LinkedList;
import java.util.List;

public class RunLengthEncoding {


    public static String rle(String input) {
        // Your code goes here
        if (input == null || "".equalsIgnoreCase(input)){
            return "";
        }
        Character character  = null;
        int length = 0;
        List<String> list  = new LinkedList<>();

        character = input.charAt(0);
        for (int i = 0; i < input.length(); i++){
            if (character == input.charAt(i)){
                length++;
            }else {
                list.add(String.valueOf(character) + length);
                character = input.charAt(i);
                length = 0;
                i--;
            }
        }
        list.add(String.valueOf(character) + length);

        String finalString = "";
        for (String s : list){
            finalString += s;
        }
        return finalString;
    }


    public static void main(String[] args)  {

        if("".equals(rle("")) &&
                "a1".equals(rle("a")) &&
                "" == (rle("")) &&
                "" == (rle(null)) &&
                "a4b3".equals(rle("aaaabbb")) &&
                "a4b3a3".equals(rle("aaaabbbaaa")) &&
                "a3".equals(rle("aaa"))){
            System.out.println("Passed");
        }else {
            System.out.println("Failed");
        }
    }

}
