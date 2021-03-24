package com.java.questions.low;

public class ReverseString {

    /**
     * public static String reverseStr( String str )
     * Example: reverseStr(str) where str is "abcd" returns "dcba".
     */
    public static String reverseStr( String str ){
        //your code goes here
        if (str == null || "".equalsIgnoreCase(str)){
            return str;
        }

        String reverse = "";
        for (int i = 0; i < str.length(); i++){
            reverse += str.charAt(str.length()-1-i);
        }

        return reverse;
    };


    public static void main(String[] args){

        String testString;
        String solution;
        boolean result = true;

        result = result && reverseStr("abcd").equals("dcba");
        result = result && reverseStr("bhjkl").equals("lkjhb");

        if(result){
            System.out.println("All tests pass");
        }
        else{
            System.out.println("There are test failures");
        }

    }

}
