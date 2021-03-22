package com.java.questions.low;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SecondSmallest {

    public static int secondSmallest(int[] x) {

        int min = Integer.MAX_VALUE;
        for (Integer integer : x){
            if (integer < min){
                min = integer;
            }
        }

        int secondMin =  Integer.MAX_VALUE;
        for (Integer integer : x){
            if (integer < secondMin && integer > min){
                secondMin = integer;
            }
        }

        if (secondMin == Integer.MAX_VALUE){
            return min;
        }
        return (secondMin);
    }

    public static void main(String args[]) {

        int[] a = { 0 };
        int[] b = { 0, 1 };
        int[] c = { 0, 0, 2 };
        int[] d = { 0, 0, 0 };

        boolean result = true;
        result &= secondSmallest(a) == 0;
        result &= secondSmallest(b) == 1;
        result &= secondSmallest(c) == 2;
        result &= secondSmallest(d) == 0;

        if (result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }

    }

}
