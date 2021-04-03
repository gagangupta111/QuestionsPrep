package com.java.questions.high;

public class Power {

    static int count = 0;

    /* Given base and integer exponent, compute value of base raised to the power of exponent.
     * Can you implement a solution faster than O(exp)?
     *
     *
     *
     *
     *
     *
     *

            public static double power(double base, int exp) {
            if (exp == 0) {
            return 1;
            }
            if (exp % 2 == 0) {
            return power(base, exp / 2) * power(base, exp / 2);
            } else {
            return base * power(base, exp / 2) * power(base, exp / 2);
            }
            }


     *
     *
     *
     */
    public static double power(double base, int exp) {
        count++;
        if (exp == 0) {
            return 1;
        }
        if (exp == 1) {
            return base;
        }
        if (exp % 2 == 0) {
            return power(base, exp / 2) * power(base, exp / 2);
        } else {
            return base * power(base, exp / 2) * power(base, exp / 2);
        }
    }

    /* returns true if all tests pass, false otherwise */
    public static boolean doTestsPass() {

        boolean doTestsPass = true;

        doTestsPass = doTestsPass && power(2,100) == 4;

        System.out.println("Count:" + count);
        return  doTestsPass;
    }

    public static void main( String[] args ) {
        if (doTestsPass())
            System.out.println("All Tests Pass");
        else
            System.out.println("There are test failures");
    }

}
