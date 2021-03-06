package com.coderpad.answers.medium;

import java.util.*;
        import java.util.HashMap;

public class CountLengthOfCycle {

    /**

     3:32

     took 30 minutes

     *
     * You have an integer array.
     * Starting from arr[startIndex], follow each element to the index it points to.
     * Continue to do this until you find a cycle.
     * Return the length of the cycle. If no cycle is found return -1



     take all values , make a string
     String makeString( int[] arr, int startIndex )

     find eligible sub strings from index 0 till length / 2
     String findFirstString(String input, int start)
     analysis: one character will not be repeated, so make a set of elements wherever an elemant is getting repeated means the substring ens there,

     check if it is repeating
     boolean doesDuplicateExist(String input, int startIndex, String subString)

     check if this string is maximum till now.

     return the max repetitive substring length.



     Solution :

     public static int countLengthOfCycle(int[] arr, int startIndex) {

     int slow = arr[startIndex];
     int fast = arr[arr[startIndex]];
     int count = 1;
     while (slow != fast) {
     slow = arr[slow];
     fast = arr[arr[fast]];
     count++;
     }
     return count;

     }

     [1,2,3,4,5,6,4], 6

     [7], 0


     12345 645 645 645




     */

    public static String makeString( int[] arr, int startIndex ) {

        String s = "";

        int currentIndex = startIndex;
        for(int i = 0; i < arr.length * 2; i++){

            s += arr[currentIndex];
            currentIndex = arr[currentIndex];


        }

        return s;

    }


    public static boolean doesDuplicateExist(String input, int startIndex, String subString){


        for(int i = startIndex; i + subString.length() <= input.length(); i++){

            if(
                    input.substring(i, i + subString.length()).equalsIgnoreCase(subString)
                    ){
                return true;
            }
        }

        return false;


    }

    public static String findFirstString(String input, int start){

        Character character = input.charAt(start);
        Set<Character> set = new HashSet<>();
        set.add(character);
        int i = start + 1;

        for(; i <= input.length(); i++){

            if(set.contains(input.charAt(i))){

                System.out.println("input : " + input);
                System.out.println("i : " + i);
                System.out.println("start : " + start);


                return input.substring(start, i);
            }else{

                set.add(input.charAt(i));
            }

        }

        return input;

    }

    public static boolean checkIndex(int[] arr, int index){


        if(index < 0 || index >= arr.length){
            return false;
        }

        return true;

    }

    public static int countLengthOfCycle(int[] arr, int startIndex) {

        if(!checkIndex(arr, startIndex) ){
            return -1;
        }

        int slow = arr[startIndex];
        if (!checkIndex(arr, slow)){
            return -1;
        }
        int fast = arr[arr[startIndex]];
        if(!checkIndex(arr, fast) ){
            return -1;
        }
        int count = 1;
        while (slow != fast) {
            slow = arr[slow];
            if(!checkIndex(arr, slow) ){
                return -1;
            }
            fast = arr[arr[fast]];
            if(!checkIndex(arr, fast) ){
                return -1;
            }
            count++;
        }

        slow = arr[slow];
        fast = arr[arr[fast]];
        count = 1;
        while (slow != fast) {
            slow = arr[slow];
            fast = arr[arr[fast]];
            count++;
        }

        return count;
    }



    public static void main( String[] args ) {

        boolean testsPassed = true;

        testsPassed  = testsPassed && countLengthOfCycle(new int[]{1, 2, 3, 4, 5, 6, 4}, 0) == 3;
        System.out.println("Length: " + countLengthOfCycle(new int[]{1, 2, 3, 4, 5, 6, 4}, 0));
        if(testsPassed) {
            System.out.println( "Test passed." );
            //return true;
        } else {
            System.out.println( "Test failed." );
            //return false;
        }


    }
}