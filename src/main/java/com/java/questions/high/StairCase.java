package com.java.questions.high;

import java.io.*;
import java.util.*;

/*

1: 1

2 : 11. 2

3 : 111,

 ** There is a staircase with 'n' number of steps. A child
 ** walks by and wants to climb up the stairs, starting at
 ** the bottom step and ascending to the top.instead
 ** of taking 1 step at a time, it will vary between taking
 ** either 1, 2 or 3 steps at a time.
 ** Given 'n' number of steps below method should find
 ** number of
 ** unique combinations the child could traverse.
 ** An example would be countSteps(3) == 4:
 ** 1 1 1
 ** 2 1
 ** 1 2
 ** 3
 */

class StairCase {
    static Map<Integer, Integer> stepsCountMap = new HashMap<Integer, Integer>();
    static {
        stepsCountMap.put(1, 1);
        stepsCountMap.put(2, 2);
        stepsCountMap.put(3, 4);
    }

    public static Integer countSteps(Integer n) {

        if (n <= 0) {
            return 0;
        }
        if (!stepsCountMap.containsKey(n)) {
            stepsCountMap.put(n, countSteps(n - 1) + countSteps(n - 2) + countSteps(n - 3));

        }
        return stepsCountMap.get(n);

    }

    public static boolean doTestsPass() {

        return countSteps(3) == 4 && countSteps(4) == 7 && countSteps(1) == 1 && countSteps(2) == 2
                && countSteps(0) == 0 && countSteps(-5) == 0 && countSteps(10) == 274 && countSteps(36) == 2082876103; // Will
        // cause
        // naive
        // solution
        // to
        // time-out
    }

    public static void main(String[] args) {
        if (doTestsPass()) {
            System.out.println("All tests pass");
        } else {
            System.out.println("Tests fail.");
        }

        for (Integer n = 1; n <= 5; n++) {
            Integer numberOfCombinations = countSteps(n);
            System.out.println(n + " steps => " + numberOfCombinations);
        }
    }
}