package com.java.questions.medium;

public class ATOI {

    // Takes a string str and returns the int value represented by
    // the string.
    //For example, atoi("42") returns 42.

    public static int atoi(String str)
    {
        if (str.contains(".")){
            if (str.charAt(0) == '.'){
                return 0;
            }
            return Integer.valueOf(str.split("\\.")[0]);
        }
        return Integer.valueOf(str);

    };

    public static boolean pass()
    {
        boolean result = true;
        result = result && (3 == atoi("3"));
        result = result && (1 != atoi("2"));
        result = result && (-1 == atoi("-1"));
        result = result && (23 == atoi("23.45"));

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
