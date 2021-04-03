package com.java.questions.medium;

public class ATOI {

    // Takes a string str and returns the int value represented by
    // the string.
    //For example, atoi("42") returns 42.

    public static int atoi(String str){
        int i = 0;
        int num = 0;
        boolean isNeg = false;

        // Check for negative sign; if it's there, set the isNeg flag
        if (str.charAt(0) == '-') {
            isNeg = true;
            i = 1;
        }

        // Process each character of the string;
        while( i < str.length()) {
            num *= 10;
            num += str.charAt(i++) - '0'; // Minus the ASCII code of '0' to get the value of the charAt(i++).
        }

        if (isNeg)
            num = -num;
        return num;
    }

    public static boolean pass()
    {
        boolean result = true;
        result = result && (-1 == atoi("-1"));
        result = result && (-123 == atoi("-123"));
        result = result && (123 == atoi("123"));

        return result;
    };

    public static void main(String[] args)
    {
        if(pass())
        {
            System.out.println("Pass");
        }
        else
        {
            System.out.println("Some fail");
        }
    }

}
