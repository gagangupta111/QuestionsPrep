package com.java.questions.medium;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class CountLengthCycle {


    /**
     *
     *
     *
     * You have an integer array.
     * Starting from arr[startIndex], follow each element to the index it points to.
     * Continue to do this until you find a cycle.
     * Return the length of the cycle. If no cycle is found return -1
     *
     * it is not possible to have no cycle.
     *
     */

    public static int countLengthOfCycle( int[] arr, int startIndex ) {

        String whole = "";
        int count = 0;
        while (count++ < arr.length * 2){
            whole += arr[startIndex];
            startIndex = arr[startIndex];
        }

        System.out.println(whole);

        arr = new int[whole.length()];
        for (int i = 0 ; i < whole.length(); i++){
            arr[i] = Integer.valueOf(String.valueOf(whole.charAt(i)));
        }

        Map<String, Integer> outerMap = new LinkedHashMap<>();

        for (int i =0 ; i < arr.length; i++){

            String s = "";
            Set<String> innerSet = new LinkedHashSet<>();

            for (int j = i; j < arr.length; j++){

                if (!innerSet.contains("" + arr[j])){
                    innerSet.add("" + arr[j]);
                    s += arr[j];
                    if (outerMap.get(s) == null){
                        outerMap.put(s, 1);
                    }else {
                        outerMap.put(s, outerMap.get(s) + 1);
                    }
                }else {
                    break;
                }
            }
        }

        int maxLength = 0;
        int maxTimes = 0;
        String key = "";

        for (Map.Entry<String, Integer> entry : outerMap.entrySet()){
            System.out.println(entry);
            if (entry.getKey().length() > maxLength){
                maxLength = entry.getKey().length();
                key = entry.getKey();
                maxTimes = entry.getValue();
            }
        }

        return maxLength;
    }

    public static void main( String[] args ) {

        boolean testsPassed = true;

        testsPassed &= countLengthOfCycle(new int[]{1, 0}, 0) == 2;
        testsPassed &= countLengthOfCycle(new int[]{1, 2, 0}, 0) == 3;
        testsPassed &= countLengthOfCycle(new int[]{1, 1, 0, 2}, 0) == 1;

        testsPassed &= countLengthOfCycle(new int[]{3, 1, 0, 2}, 0) == 3;

        testsPassed &= countLengthOfCycle(new int[]{1, 2, 3, 0}, 0) == 4;

        if(testsPassed) {
            System.out.println( "Test passed." );
            //return true;
        } else {
            System.out.println( "Test failed." );
            //return false;
        }

    }

}
