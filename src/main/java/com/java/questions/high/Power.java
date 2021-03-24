package com.java.questions.high;

public class Power {


    /* Given base and integer exponent, compute value of base raised to the power of exponent.
     * Can you implement a solution faster than O(exp)?
     */
    public static double power(double base, int exp) {
        //your code

        if (exp == 0){
            return 1;
        }

        double result = base;
        while (exp-- > 1){
            result = base * result;
        }
        return result;
    }

    /* returns true if all tests pass, false otherwise */
    public static boolean doTestsPass() {
        boolean doTestsPass = true;

        doTestsPass = doTestsPass && power(2,2) == 4;
        doTestsPass = doTestsPass && power(2,3) == 8;
        doTestsPass = doTestsPass && power(2.0,2) == 4.0;
        doTestsPass = doTestsPass && power(2.0,1) == 2.0;
        doTestsPass = doTestsPass && power(2.0,0) == 1;

        return  doTestsPass;
    }

    public static void main( String[] args ) {
        if (doTestsPass())
            System.out.println("All Tests Pass");
        else
            System.out.println("There are test failures");
    }

}
