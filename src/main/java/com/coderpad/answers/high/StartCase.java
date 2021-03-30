package com.coderpad.answers.high;

import java.io.*;
        import java.util.*;

/*

 ** There is a staircase with 'n' number of steps. A child
 ** walks by and wants to climb up the stairs, starting at
 ** the bottom step and ascending to the top.instead
 ** of taking 1 step at a time, it will vary between taking
 ** either 1, 2 or 3 steps at a time.
 ** Given 'n' number of steps below method should find
 ** number of
 ** unique combinations the child could traverse.
 ** An example would be countSteps(3) == 4:
 ** 1 1 1
 ** 2 1
 ** 1 2
 ** 3

    get highest String Possible
    String giveHighestString(int input, Character character)

    get highest character present
    Character giveHighestIntegerCharacter(String input){

    get second highest string
    String secondHighestString(String input)

    create permutations function
    int permute(int n)

    get all permutations possible
    int noOfPermutations(String input)





 */

class StartCase
{
    public static Integer countSteps(Integer n)
    {
        int permutations  = 0;
        String highestString = giveHighestString(n, '3');

        Character c = giveHighestIntegerCharacter(highestString);

        while (c != '1'){
            permutations += noOfPermutations(highestString);
            highestString = secondHighestString(highestString);
            c = giveHighestIntegerCharacter(highestString);
        }

        if (n % 2 == 0){
            permutations += 1;
        }
        return permutations + 1;
    }

    public static int permute(int n){

        int result = n;
        while (n > 1){

            result *= n-1;
            n--;

        }

        return result;

    }

    public static int noOfPermutations(String input){

        Map<Integer, Integer> set = new LinkedHashMap<>();

        for (int i = 0 ; i < input.length(); i++){

            if (set.get(Integer.valueOf(input.charAt(i) + "")) == null){
                set.put(Integer.valueOf(input.charAt(i) + ""), 1);
            }else {
                set.put(Integer.valueOf(input.charAt(i) + ""), set.get(Integer.valueOf(input.charAt(i) + "")) + 1);
            }
        }

        int upper = permute(input.length());
        int down = 1;

        for (Integer integer : set.keySet()){

            down *= permute(set.get(integer));

        }

        return upper / down;

    }

    public static String giveHighestString(int input, Character character){

        String finalString = "";

        while (input >= Integer.valueOf(character + "")){

            finalString += Integer.valueOf(character + "");
            input  = input - Integer.valueOf(character + "");

        }

        if (input > 0){
            finalString += input;
        }

        return finalString;
    }

    public static Character giveHighestIntegerCharacter(String input){

        char highest = '0';

        for (int i = 0 ; i < input.length(); i++){

            if (input.charAt(i) > highest){
                highest = input.charAt(i);
            }

        }

        return highest;
    }

    public static String secondHighestString(String input){

        Character highestCharacter = giveHighestIntegerCharacter(input);

        switch (highestCharacter){

            case '3':
                for (int i = 0 ; i < input.length(); i++){
                    if (input.charAt(i) == '3'){

                        input = input.substring(0, i) + "21" + input.substring(i+1, input.length());
                        break;

                    }
                }
                return input;

            case '2':
                for (int i = 0 ; i < input.length(); i++){
                    if (input.charAt(i) == '2'){

                        input = input.substring(0, i) + "11" + input.substring(i+1, input.length());
                        break;

                    }
                }
                return input;

            case '1':
                return input;
        }

        return input;
    }

    public static boolean doTestsPass()
    {
        return countSteps(4) == 7;
    }

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

        for (Integer n = 1; n <= 5; n++)
        {
            Integer numberOfCombinations = countSteps(n);
            System.out.println(n + " steps => " + numberOfCombinations);
        }
    }
}