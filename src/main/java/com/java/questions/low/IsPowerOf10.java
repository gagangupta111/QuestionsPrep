package com.java.questions.low;

public class IsPowerOf10 {

    /**
     * Returns true if x is a power-of-10.
     */
    public static boolean isPowerOf10(int x)
    {
        // your code goes here

        String s = "" + x;

        if (s.charAt(0) != '1'){
            return false;
        }

        for (int i = s.length() - 1 ; i > 0; i--){
            if (s.charAt(i) != '0'){
                return false;
            }
        }

        return true;
    }

    public static boolean doTestsPass()
    {
        int[] isPowerList = {10, 10000};
        int[] isNotPowerList = {3, 2000};

        for(int i : isPowerList)
        {
            if(!isPowerOf10(i))
            {
                System.out.println("Test failed for: " + i);
                return false;
            }
        }

        for(int i : isNotPowerList)
        {
            if(isPowerOf10(i))
            {
                System.out.println("Test failed for: " + i);
                return false;
            }
        }

        System.out.println("All tested passed");
        return true;
    };


    public static void main(String args[])
    {
        doTestsPass();
    }

}
