package com.coderpad.answers.low;

import java.util.*;

public class SecondSmallest {
    /**
     * int secondSmallest(int[] x)
     */
    public static int secondSmallest(int[] x) {

        if(x == null){
            return Integer.MIN_VALUE;
        }

        if(x.length == 1){
            return x[0];
        }


        List<Integer> list = new ArrayList<>();

        for(int i : x){
            list.add(i);
        }

        Collections.sort(list);

        int firstMax = list.get(0);

        for(Integer integer : list){

            if(integer > firstMax){
                return integer;}

        }

        // Your code
        return firstMax;
    }

    public static void main(String args[]) {

        int[] a = { 0 };
        int[] b = { 0, 1 };

        boolean result = true;
        result &= secondSmallest(a) == 0;
        result &= secondSmallest(b) == 1;

        if (result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }

    }
}