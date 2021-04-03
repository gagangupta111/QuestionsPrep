package com.coderpad.answers.high;


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
 * **            ___                 ___
 **            |   |*    *   *   * |   | *   *  ___
 **            |   |*    *  _*_  * |   |_*_  * |   |
 **         ___|   |*   _*_|   | * |   |   | * |   |
 **     ___|___|___|*__|___|___|_*_|___|___|_*_|___|___
 **     {0,  1,  4,  0,  1,  2,  0,  4,  2,  0,  3,  0}
 *
 **      19 here
 **  2) Consider adding some additional tests in doTestsPass().
 **  3) Implement computeSnowpack() correctly.
 *
 *
 *
 *      Solution :
 *
 *
 *      1. Create a function which return the highest mountain index which has not been consumed yet
 *      int getHighestNotConsumedIndexMountain(List<Integer> array, Set<Integer> consumedIndexes)
 *
 *      2. Keep firstHighest as same, gather secondHighest mountain every time from above function.
 *
 *      3. calculate the snow packs between these 2 mountains, and keep on adding indexes in consumed list
 *      void consumeSnowPacks(List<Integer> array, int oneIndex, int secondIndex, Set<Integer> consumedIndexes)
 *
 *      4. repeat step 2 and 3 till the function getHighestNotConsumedIndexMountain returns -1;
 *

public static Integer computeSnowpack(Integer[] arr) {
    if (arr.length < 3) {
        return 0;
    }
    int sum = 0;
    int[] left = new int[arr.length];
    int[] right = new int[arr.length];
    left[0] = arr[0];
    for (int i = 1; i < arr.length; i++) {
        left[i] = Math.max(arr[i], left[i - 1]);
    }
    left[arr.length - 1] = arr[arr.length - 1];
    for (int i = arr.length - 2; i >= 0; i--) {
        right[i] = Math.max(arr[i], right[i + 1]);
    }
    for (int i = 0; i < arr.length; i++) {
        sum += Math.min(left[i], right[i]) - arr[i];
    }
    return sum;
}


 */


import java.util.*;

class SnowPack
{
    /*
     **  Find the amount of snow that could be captured.
     */

    public static int getHighestMountainIndexNonConsumed(List<Integer> list, Set<Integer> consumed){

        int maxHeight  = -1;
        int heighestIndex = -1;

        for (int i = 0; i < list.size(); i++){

            if (list.get(i) > maxHeight && !consumed.contains(i)){
                maxHeight = list.get(i);
                heighestIndex = i;

            }

        }

        return heighestIndex;

    }

    public static int consumeSnowPack(List<Integer> list, Set<Integer> consumed, int one, int two){

        int snowPack = 0;

        int start = -1;
        int end = -1;

        int shortHeightIndex = -1;

        if (one < two){
            start = one;
            end = two;
        }else {
            end = one;
            start = two;
        }

        if (list.get(start) < list.get(end)){

            shortHeightIndex = start;

        }else {
            shortHeightIndex = end;
        }

        while (start <= end){

            if (!consumed.contains(start)){

                if (list.get(start) < list.get(shortHeightIndex)) {
                    snowPack += list.get(shortHeightIndex) - list.get(start);
                }

            }
            consumed.add(start);
            start++;

        }

        return snowPack;

    }


    public static Integer computeSnowpack(Integer[] arr)
    {

        int snowPack = 0;

        Set<Integer> consumed = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int i : arr){
            list.add(i);
        }

        int highestMountainIndex  = getHighestMountainIndexNonConsumed(list, consumed);
        consumed.add(highestMountainIndex);

        int secondHighestIndex = getHighestMountainIndexNonConsumed(list, consumed);

        while (secondHighestIndex != -1){

            snowPack += consumeSnowPack(list, consumed, highestMountainIndex, secondHighestIndex);
            secondHighestIndex = getHighestMountainIndexNonConsumed(list, consumed);

        }

        // Todo: Implement computeSnowpack
        return snowPack;
    }

    /*
     **  Returns true if the tests pass. Otherwise, returns false;
     */
    public static boolean doTestsPass()
    {
        boolean result = true;
        result &= computeSnowpack(new Integer[]{0,1,3,0,1,2,0,4,2,0,3,0}) == 13;

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