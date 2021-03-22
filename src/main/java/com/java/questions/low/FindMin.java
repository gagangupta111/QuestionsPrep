package com.java.questions.low;

public class FindMin {

    public static int FindMin(int a[])
    {
        /*
         ** Your code goes here
         */

        if (a.length == 0){
            return -1;
        }

        int min = Integer.MAX_VALUE;

        for (Integer integer : a){
            if (integer < min){
                min = integer;
            }
        }

        return min;
    }

    public static void main(String args[])
    {
        boolean result = true;
        result = result && FindMin(new int[]{3,4,5,6,1,2}) == 1;
        result = result && FindMin(new int[]{2,1}) == 1;
        result = result && FindMin(new int[]{1}) == 1;

        try {
            FindMin(null);
            result = false;
        }
        catch(Exception e)
        {
            result = result && true;
        }

        if(result)
        {
            System.out.println("All tests pass");
        }
        else
        {
            System.out.println("There are test failures");
        }
    }

}
