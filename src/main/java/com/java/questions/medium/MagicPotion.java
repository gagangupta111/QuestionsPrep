package com.java.questions.medium;


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

getNext substring to check for repetition
String getNext(String original, int startIndex, String origSub).

loop ith index to the original substring length - 1
i = origSub.length() - 1;

check if this substring repeats down the line
boolean doesRepeatExist(String input, int startIndex, String inputSubString).

result = combine the encoded substring + original string starts from original substring length till full length


*/

public class MagicPotion {


    public static boolean feasible(String input, int startIndex, String inputSubString){

        if (startIndex > input.length() || startIndex + inputSubString.length() > input.length()){
            return false;
        }

        return true;

    }

    public static String getNext(String original, int startIndex, String origSub){

        return original.substring(startIndex, startIndex + origSub.length());

    }

    public static boolean doesRepeatExist(String input, int startIndex, String inputSubString){

        String subString = input.substring(startIndex, startIndex + inputSubString.length());
        if (subString.equalsIgnoreCase(inputSubString)){
            return true;
        }else {
            return false;
        }

    }


    private static int minimalSteps( String original )
    {

        if (original.length() == 1){
            return 1;
        }

        int i = 0;
        String origSub = original.substring(0,i+1);
        String newSub = original.substring(0,i+1);

        while (i < original.length()){

            if (feasible(original, i+1, origSub)){

                if (doesRepeatExist(original, i+1, origSub)){

                    origSub = origSub + getNext(original, i+1, origSub);
                    newSub = newSub + "*";

                }else {

                    origSub = origSub + original.substring(i+1, i+2);
                    newSub = newSub + original.substring(i+1, i+2);

                }

            }else {
                break;
            }


            i = origSub.length() - 1;
        }

        String result = (newSub + original.substring(origSub.length(), original.length()));
        System.out.println("Input: " + original + " : result : " + result);
        return result.length();

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
