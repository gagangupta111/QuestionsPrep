package com.java.questions.low;

import java.util.LinkedHashSet;
import java.util.Set;

public class FirstNonRepeating {

    public static char findFirst(String input)
    {

        Set<Character> repeating = new LinkedHashSet<>();
        Character found = null;
        outerLoop:
        for (int i = 0; i < input.length(); i++){
            Character character = input.charAt(i);
            if (repeating.contains(character)){
                continue;
            }
            for (int j = i+1; j < input.length(); j++ ){
                if (character == input.charAt(j)){
                    repeating.add(character);
                    continue outerLoop;
                }
            }
            return character;
        }
        return '1';
    }

    public static void main(String args[])
    {

        String[] inputs = {"apple","racecars", "ababdc", "aaaaaa"};
        char[] outputs = {'a', 'e', 'd', '1' };

        boolean result = true;
        for(int i = 0; i < inputs.length; i++ )
        {
            result = result && findFirst(inputs[i]) == outputs[i];
            if(!result)
                System.out.println("Test failed for: " + inputs[i]);
            else
                System.out.println("Test passed for: " + inputs[i]);
        }
    }

}
