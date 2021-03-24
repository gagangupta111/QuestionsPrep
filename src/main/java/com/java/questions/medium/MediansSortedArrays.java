package com.java.questions.medium;

public class MediansSortedArrays {

    public static double logic(int[] A, int[] B) {

        int finalArray[] = new int[A.length + B.length];

        int i = 0;
        int j = 0;
        int k = 0;
        for ( ; i < A.length && j < B.length;){
            if (A[i] < B[j]){
                finalArray[k++] = A[i++];
            }else {
                finalArray[k++] = B[j++];
            }
        }

        if (i != A.length){
            while (i != A.length){
                finalArray[k++] = A[i++];
            }
        }

        if (j != B.length){
            while (j != B.length){
                finalArray[k++] = B[j++];
            }
        }

        if (finalArray.length % 2 == 0){
            return (finalArray[finalArray.length/2 - 1] + finalArray[finalArray.length/2])/2.0;
        }else return finalArray[finalArray.length/2];
    }

    public static boolean pass()
    {
        boolean result = true;
        result = result && logic(new int[]{1, 3}, new int[]{2, 4}) == 2.5;
        result = result && logic(new int[]{10,11,12,13,14}, new int[]{8,9, 15, 16}) == 12;
        return result;
    };

    public static void main(String[] args)
    {
        if(pass())
        {
            System.out.println("pass");
        }
        else
        {
            System.out.println("some failures");
        }
    }

}
