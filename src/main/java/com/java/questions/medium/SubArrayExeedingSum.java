package com.java.questions.medium;

import java.util.*;

public class SubArrayExeedingSum {

    public static int subArrayExceedsSum(int arr[], int target )
    {

        List<Integer> sizes = new ArrayList<>();

        for (int i = 0; i < arr.length; i++){

            int sum = 0;
            for (int j = i; j < arr.length; j++){

                sum += arr[j];
                if (sum > target){
                    sizes.add( j  - i + 1);
                    break;
                }
            }

        }

        Collections.sort(sizes);
        if (sizes.isEmpty()){
            return -1;
        }
        return sizes.get(0);
    }

    /**
     * Execution entry point.
     */
    public static void main(String[] args)
    {

        boolean result = true;
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        result = result && subArrayExceedsSum( arr, 6 ) == 1; // 7
        result = result && subArrayExceedsSum( arr, 12 ) == 2; // 7,6
        result = result && subArrayExceedsSum( arr, 20 ) == 4; // 4,5,6,7

        if( result )
        {
            System.out.println("All tests pass\n");
        }
        else
        {
            System.out.println("There are test failures\n");
        }
    }

}
