package com.coderpad.answers.medium;

import java.util.Set;

public class MedianOf2SortedArrays {


    public static void main(String[] args) {

        boolean pass = true;
        int[] arr1 = {1,2,3,4};
        int[] arr2 = {4,5,6,7};
        int[] merge = {1,2,3,4,4,5,6,7};
        System.out.println(mergeArrays(arr1, arr2));

        arr1 = new int[]{1,5};
        arr2 = new int[]{4,6,7};
        merge = new int[]{1,4,5,6,7};

        System.out.println(mergeArrays(arr1, arr2));


        if( pass ) {
            System.out.println( "Test passed." );

        } else {
            System.out.println( "Test failed." );

        }
    }


    public static int[] mergeArrays(int[] arr1, int[] arr2){

        int[] mergedArray = new int[arr1.length + arr2.length];

        int i = 0;
        int j = 0;
        int k = 0;

        for (; i < arr1.length && j < arr2.length && k < mergedArray.length; k++){
            if (arr1[i] < arr2[j]){
                mergedArray[k] = arr1[i];
                i++;
            }else {
                mergedArray[k] = arr2[j];
                j++;
            }
        }

        if (i < arr1.length){

            for (; i < arr1.length; i++, k++){

                mergedArray[k] = arr1[i];

            }

        }

        if (j < arr2.length){

            for (; j < arr2.length; j++, k++){

                mergedArray[k] = arr2[j];

            }

        }

        return mergedArray;

    }

}