package com.java.questions.medium;

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
        return result.length();

    }

    public static void main( String[] args ) {

        boolean pass = true;

        pass = pass && minimalSteps("ABCDABCEABABCDE") == 15;
        pass = pass && minimalSteps("AAAABBBB") == 7;
        pass = pass && minimalSteps("ABAB") == 3;
        pass = pass && minimalSteps("AAAA") == 3;
        pass = pass && minimalSteps("AAAAB") == 4;

        if (pass) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }
}
