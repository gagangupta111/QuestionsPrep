package com.coderpad.answers.medium;

/*
Question:
Combine ingredients in a specific order, any of which may be repeated

As an example, consider the following
(A,B,C,D) in 11 steps: A, B, A, B, C, A, B, A, B, C, E

Encode the string above using only 6 characters: A,B,*,C,*,E

AA    A*
ABCDABCE    ABCDABCE
ABCABCE    ABC*E
AAA    A*A
AAAA    A**
BBB    B*B
AAAAAA    A**AA

Implement function that takes as input an un-encoded potion and returns the
minimum number of characters required to encode

Solution :

Create original Substring, and encoded substring at 0th character
start from 0th index ,

keep on checking recursively if we shall move ahead with the sub string check.
boolean feasible(String input, int startIndex, String inputSubString).

getNext substring
String getNext(String original, int startIndex, String origSub).

loop ith index to the original substring length - 1
i = origSub.length() - 1;

check if this substring repeats down the line
boolean doesRepeatExist(String input, int startIndex, String inputSubString).

result = combine the encoded substring + original string starts from original substring length till full length

*/

public class MagicPotion
{
    public static boolean feasible(String input, int startIndex, String subString){

        if(startIndex + subString.length() > input.length()){
            return false;
        }

        return true;

    }


    public static String getNextSubString(String input, int startIndex, String subString){

        return input.substring(startIndex, startIndex + subString.length());

    }

    public static boolean doesRepeatExist(String input, int startIndex, String subString){

        if (input.substring(startIndex, startIndex + subString.length()).equalsIgnoreCase(subString)){

            return true;

        }else {

            return false;

        }

    }

    private static int minimalSteps( String input )
    {

        // null checks


        // logic starts
        int i = 0;
        String subString = input.substring(0, 1);
        String encoded = input.substring(0, 1);

        for ( ; i < input.length();){

            if (feasible(input, i+1, subString)){

                if (doesRepeatExist(input, i+1, subString)){

                    subString += getNextSubString(input, i+1, subString);
                    encoded += "*";

                }else {

                    subString += input.substring(i+1, i+2);
                    encoded += input.substring(i+1, i+2);

                }
            }else {
                break;
            }

            i = subString.length() - 1;

        }
        encoded += input.substring(subString.length(), input.length());
        System.out.println("Input: " + input + " : result : " + encoded);
        return encoded.length();
    }

    public static void main( String[] args ) {

        boolean pass = true;

        pass = pass && minimalSteps("ABCDABCEABABCDE") == 15;
        pass = pass && minimalSteps("ABCDABCDABABCDE") == 12;
        pass = pass && minimalSteps("AAAABBBB") == 7;
        pass = pass && minimalSteps("ABAB") == 3;
        pass = pass && minimalSteps("AAAA") == 3;
        pass = pass && minimalSteps("AAAAB") == 4;
        pass = pass && minimalSteps("AAAAAA") == 5;

        if (pass) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }
}