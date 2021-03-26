package com.java.questions.high;

/* Problem Name is &&& Snowpack &&& PLEASE DO NOT REMOVE THIS LINE. */

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
 **     {0,  1,  3,  0,  1,  2,  0,  4,  2,  0,  3,  0}
 **                                 ___
 **             ___                |   |        ___
 **            |   | *   *  _*_  * |   |_*_  * |   |
 **         ___|   | *  _*_|   | * |   |   | * |   |
 **     ___|___|___|_*_|___|___|_*_|___|___|_*_|___|___
 **     {0,  1,  3,  0,  1,  2,  0,  4,  2,  0,  3,  0}
 **
 **     Solution: In this example 13 units of snow (*) could be captured.
 *
 *
 * **            ___                ___
 **            |   |*    *   *   * |   |        ___
 **            |   |*    *  _*_  * |   |_*_  * |   |
 **         ___|   |*   _*_|   | * |   |   | * |   |
 **     ___|___|___|*__|___|___|_*_|___|___|_*_|___|___
 **     {0,  1,  4,  0,  1,  2,  0,  4,  2,  0,  3,  0}
 *
 **      17 here
 **  2) Consider adding some additional tests in doTestsPass().
 **  3) Implement computeSnowpack() correctly.
 */


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SnowPack {

    /*
     **  Find the amount of snow that could be captured.
     */

    private static int capturedSnow = 0;

    public static int findHighestHillIndex(List<Integer> queue, Integer[] arr){


        Map<Integer, Integer> map = new LinkedHashMap<>();

        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (Integer index : queue){

            if (arr[index] > max){
                max = arr[index];
                maxIndex = index;
            }

        }

        queue.remove(new Integer(maxIndex));
        return maxIndex;

    }

    public static void captureAllHillsSnow(int startIndex, int endIndex, List<Integer> queue, List<Integer> captured, Integer[] arr){


        int shorterHillHeight = arr[startIndex] < arr[endIndex] ? arr[startIndex] : arr[endIndex];

        while (startIndex <= endIndex){

            if (!captured.contains(new Integer(startIndex))){
                if (shorterHillHeight - arr[startIndex] > 0){
                    capturedSnow += shorterHillHeight - arr[startIndex];
                }
                queue.remove(new Integer(startIndex));
                captured.add(new Integer(startIndex));
            }
            startIndex++;
        }

    }

    public static Integer computeSnowpack(Integer[] arr)
    {
        capturedSnow = 0;
        List<Integer> capturedIndex = new ArrayList<>();
        List<Integer> queueIndex = new ArrayList<>();

        int length  = arr.length;

        for (int i = 0; i < arr.length; i++){

            queueIndex.add(i);

        }

        int maxIndex = findHighestHillIndex(queueIndex, arr);

        while (!queueIndex.isEmpty()){
            int secondMaxIndex = findHighestHillIndex(queueIndex, arr);
            int startIndex = -1;
            int endIndex = -1;
            if (maxIndex < secondMaxIndex){
                startIndex = maxIndex;
                endIndex = secondMaxIndex;
            }else {
                startIndex = secondMaxIndex;
                endIndex = maxIndex;
            }
            captureAllHillsSnow(startIndex, endIndex, queueIndex, capturedIndex, arr);

        }


        // Todo: Implement computeSnowpack
        return capturedSnow;
    }

    /*
     **  Returns true if the tests pass. Otherwise, returns false;
     */
    public static boolean doTestsPass()
    {
        boolean result = true;
        result &= computeSnowpack(new Integer[]{0,1,3,0,1,2,0,4,2,0,3,0}) == 13;
        result &= computeSnowpack(new Integer[]{0,1,4,0,1,2,0,4,2,0,3,0}) == 17;
        result &= computeSnowpack(new Integer[]{4,1,5,0,1,2,0,4,2,0,3,0}) == 20;

        return result;
    }

    /*
     **  Execution entry point.
     */
    public static void main(String[] args)
    {
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
