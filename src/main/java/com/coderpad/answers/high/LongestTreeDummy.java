package com.coderpad.answers.high;

/*
 **  Instructions:
 **
 **  Given a forest ( one or more disconnected trees ), find the root of largest tree
 **  and return its Id. If there are multiple such roots, return the smallest Id of them.
 **
 **  Complete the largestTree function in the editor below.
 **  It has one parameter, immediateParent, which is a map containing key-value pair indicating
 **  child -> parent relationship. The key is child and value is the corresponding
 **  immediate parent.
 **  Constraints
 **    - Child cannot have more than one immediate parent.
 **    - Parent can have more than one immediate child.
 **    - The given key-value pair forms a well-formed forest ( a tree of n nodes will have n-1 edges )
 **
 **  Example:
 **
 **  Input:
 **  { { 1 -> 2 }, { 3 -> 4} }
 **
 **  Expected output: 2
 **  Explanation: There are two trees one having root of Id 2 and another having root of Id 4.
 **  Both trees have size 2. The smaller number of 2 and 4 is 2. Hence the answer is 2.
 */

import java.util.*;
import java.util.stream.Collectors;

public class LongestTreeDummy
{

    /*
     **  Find the largest tree.
     */
    public static Integer largestTree(final Map<Integer,Integer> immediateParent)
    {
        return 0;
    }

    /*
     **  Returns true if the tests pass. Otherwise, returns false;
     */
    public static boolean doTestsPass()
    {

        // map of test cases to expected results
        final Map<Map<Integer,Integer>, Integer> testCases = new HashMap<>();

        // example
        final Map<Integer,Integer> testCaseOneKey = new HashMap<Integer, Integer>() {{
            put(1,2);
            put(3,4);
        }};
        testCases.put(testCaseOneKey, 2);

        // More than two trees
        final Map<Integer,Integer> testCaseTwoKey = new HashMap<Integer, Integer>() {{
            put( 2, 3 );
            put( 7, 8 );
            put( 12, 15 );
            put( 3, 1 );
            put( 13, 15 );
            put( 11, 15 );
            put( 9, 8 );
            put( 5, 12 );
        }};
        testCases.put(testCaseTwoKey, 15);

        // really large index values
        final Map<Integer,Integer> testCaseThreeKey = new HashMap<Integer, Integer>() {{
            put( 2, 3 );
            put( 5, 2 );
            put( 7, 3 );
            put( 6, 7 );
            put( 9, 4 );
            put( 1, 4 );
            put( 8, 4 );
            put( 1, 4 );
        }};
        testCases.put(testCaseThreeKey, 3);

        // two trees of same size
        final Map<Integer,Integer> testCaseFourKey = new HashMap<Integer, Integer>() {{
            put( 9, 4 );
            put( 1, 4 );
            put( 10, 4 );
            put( 8, 4 );

            put( 5, 2 );
            put( 2, 3 );
            put( 7, 3 );
            put( 6, 7 );

        }};
        testCases.put(testCaseFourKey, 3);

        // tree sizes differ by one
        final Map<Integer,Integer> testCaseFiveKey = new HashMap<Integer, Integer>() {{
            put( 35, 33 );
            put( 33, 28 );
            put( 31, 22 );
            put( 28, 25 );
            put( 34, 31 );
            put( 29, 27 );
            put( 21, 23 );
            put( 25, 21 );
            put( 22, 29 );
        }};
        testCases.put(testCaseFiveKey, 23);

        boolean passed = true;
        for(Map.Entry<Map<Integer,Integer>, Integer> entry : testCases.entrySet())
        {
            final Integer actual = largestTree(entry.getKey());
            if(!actual.equals(entry.getValue()))
            {
                passed = false;
                System.out.println("Failed for " + entry.getKey().toString() + "\n  expected " + entry.getValue() + ", actual " + actual);
            }
        }

        return passed;
    }

    /*
     **  Execution entry point.
     */
    public static void main(String[] args)
    {
        // Run the tests
        if(doTestsPass())
        {
            System.out.println("All tests pass");
        }
        else
        {
            System.out.println("Tests fail.");
        }
    }
}
