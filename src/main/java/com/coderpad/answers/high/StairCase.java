package com.coderpad.answers.high;

import java.util.HashMap;
import java.util.Map;

public class StairCase {

    private static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args){

        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 4);

        System.out.println("Hello!");
        System.out.println(countSteps(6));

    }

    public static int countSteps(int n){

        if (n <= 0){
            return 0;
        }

        if (!map.containsKey(n)){
            map.put(n, countSteps(n-1) + countSteps(n-2 ) + countSteps(n-3));
        }

        return map.get(n);

    }

}


