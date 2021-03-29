package com.coderpad.answers.high;

public class DecimalConversio {


    /**
     * Return the fraction output in the following way Examples: If after decimal,
     * repeating numbers are there in the output . eg. 1/3=0.333333333, this should
     * be represented as 0.(3) 6/11=0.54545454, this should be represented as 0.(54)
     * fractionRepresentation(1,2)=0.5 fractionRepresentation(1,3)=0.(3)
     * fractionRepresentation(6,11)=0.(54)

     Solution :

     get the whole String with decimal values ,

     1.. first get the remainder and divident separately
     2.. repeatedly remainder = remainder * 10, and checking if remainder*10 % dem = 0,
     3.. keep on adding the dividend into the string will length 20

     now get the fractional component first string
     String findFirstString(String input, int start, int end)

     check if this is repetitive string
     boolean doesRepeatExist(String input, String subString)

     if repititive found then return as (repititive)
     else return the fractional component as it is

     combine divident + "." + fractional result



     */




    // 10:19

    public static String findFirstString(String input, int start, int end){

        return input.substring(start, end);

    }

    public static boolean doesRepeatExist(String input, String subString){

        return subString.equals(input.substring(subString.length(), subString.length()*2));

    }

    public static String fractionRepresentation(int num, int den) {

        int dividend  = num/den;
        int rest = num % den;

        if (rest == 0){

            return "" + dividend + ".0";

        }

        String fullrest = "";

        while (fullrest.length() < 20 && rest != 0){

            fullrest += (rest * 10) / den;
            rest = (rest * 10) % den;

        }

        String fractional = dividend + "." + fullrest;
        boolean found = false;
        String findFirstString = "";

        for (int i = 1; i < fullrest.length(); i++){

            findFirstString  = findFirstString(fullrest, 0, i);
            if (doesRepeatExist(fullrest, findFirstString)){

                found = true;
                break;

            }

        }

        String finalFractional = "";
        if (found){
            finalFractional =  "(" + findFirstString + ")";
        }else {

            finalFractional = fullrest;
        }

        System.out.println(dividend + "." + finalFractional);
        return (dividend + "." + finalFractional);
    }

    public static void main(String args[]) {
        // float f=6/11f;
        // System.out.println(f);
        System.out.println(fractionRepresentation(1, 2) + " " + fractionRepresentation(1, 3) + " "
                + fractionRepresentation(6, 11));

        if (fractionRepresentation(1, 2).equals("0.5") && fractionRepresentation(6, 11).equals("0.(54)")
                && fractionRepresentation(1, 3).equals("0.(3)")) {
            System.out.println("All passed");
        } else {
            System.out.println("Failed");
        }

    }
}