package com.coderpad.answers.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubArrayExceedingSum
{
    public static int subArrayExceedsSum(int arr[], int target )
    {

        List<Integer> sortedArray = new ArrayList<>();
        for (int i : arr){
            sortedArray.add(i);
        }

        Collections.sort(sortedArray, Collections.reverseOrder());

        int sum = 0;
        int i = 0;
        int count = 0;
        boolean found = false;
        for ( ; i < sortedArray.size(); i++){

            count++;
            sum += sortedArray.get(i);
            if (sum > target){

                found = true;
                break;

            }

        }


        if (found){
            return count;
        }else {
            return -1;
        }
    }

    /**
     * Execution entry point.
     */
    public static void main(String[] args)
    {
        boolean result = true;
        int[] arr = { 1, 2, 3, 4, 9 };
        result = result && subArrayExceedsSum( arr, 6 ) == 1;
        result = result && subArrayExceedsSum( arr, 12 ) == 2;

        if( result )
        {
            System.out.println("All tests pass\n");
        }
        else
        {
            System.out.println("There are test failures\n");
        }
    }
};