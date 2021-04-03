package com.coderpad.answers.high;

 /*
         ** Instructions to candidate.
         **  1) Given an array of non-negative integers representing the elevations
         **     from the vertical cross section of a range of hills, determine how
         **     many units of snow could be captured between the hills.
         **
         **     See the example array and elevation map below.
         **                                 ___
         **             ___                |   |        ___
         **            |   |        ___    |   |___    |   |
         **         ___|   |    ___|   |   |   |   |   |   |
         **     ___|___|___|___|___|___|___|___|___|___|___|___
         **     {0,  1,  3,  0,  1,  2,  0,  4,  2,  0,  3,  0} arr[4] = 1;
         *                                                      left[4] = 3;
         *                                                      right[4] = 4;
         **                                 ___
         **             ___                |   |        ___
         **            |   | *   *  _*_  * |   |_*_  * |   |
         **         ___|   | *  _*_|   | * |   |   | * |   |
         **     ___|___|___|_*_|___|___|_*_|___|___|_*_|___|___
         **     {0,  1,  3,  0,  1,  2,  0,  4,  2,  0,  3,  0}
         *
         * sum = 0;
         *
         * a[0] = 0;
         * left = 0;
         * right = 4;
         *
         * sum = sum + Math.min(left, right) - a[0];
         *
         * sum = 0 + 0 - 0 = 0
         *
         * a[1] = 1;
         * left = 1;
         * right = 4;
         *
         * sum = 0 + 1 - 1 = 0
         *
         * a[2] = 3;
         *
         *
         *
         **
         **     Solution: In this example 13 units of snow (*) could be captured.
         **
         **  2) Consider adding some additional tests in doTestsPass().
         **  3) Implement computeSnowpack() correctly.
         */
        import java.io.*;
        import java.util.*;
public class SnowPackDhruv {
    /*
     **  Find the amount of snow that could be captured.
     */
    public static Integer computeSnowpack(Integer[] arr) {

        return 0;


    }
    /*
     **  Returns true if the tests pass. Otherwise, returns false;
     */
    public static boolean doTestsPass() {
        boolean result = true;
        System.out.println(computeSnowpack(new Integer[]{0, 1, 3, 0, 1, 2, 0, 4, 2, 0, 3, 0}));
        result &= computeSnowpack(new Integer[]{0, 1, 3, 0, 1, 2, 0, 4, 2, 0, 3, 0}) == 13;
        return result;
    }
    /*
     **  Execution entry point.
     */
    public static void main(String[] args) {
        if (doTestsPass()) {
            System.out.println("All tests pass");
        } else {
            System.out.println("Tests fail.");
        }
    }
}