package com.coderpad.answers.low;

import java.util.ArrayList;
import java.util.List;

public class SquareRoot {
    /*
     *   double squareRoot( double x )
     *
     */

    public static List<String> getValueAsList(String value){

        String[] split = value.split("\\.");
        List<String> firstPart = new ArrayList<>();

        if (split[0].length() == 1){
            firstPart.add(split[0]);
            return firstPart;
        }


        int i = split[0].length() - 2;
        for (; i >= 0; i = i -2){

            firstPart.add(split[0].substring(i, i+2));

        }

        if (i == -1){
            firstPart.add(split[0].substring(0,1));
        }

        return firstPart;

    }

    public static int findMaxPrimeRoot(int x){

        int previous = 1;
        for (int i = 1; i <= x; i++){

            if ( i * i < x){

                previous = i;

            }else {
                break;
            }

        }

        return previous;

    }

    public static double squareRoot( double x )
    {


        String divider = "";
        String divisible = "";
        String dividend = "";

        System.out.println("SquareRoot: ");
        List<String> list = getValueAsList(String.valueOf(x));
        for (int i = list.size()-1; i >= 0; i--){

            // expand divisible and divider
            String value = list.get(i);
            int suffixDivider = findMaxPrimeRoot(Integer.valueOf(divisible + value));

            divider += suffixDivider;
            divider = String.valueOf(Integer.valueOf(divider) + Integer.valueOf(suffixDivider));

            divisible =  "" + (Integer.valueOf(divisible) % Integer.valueOf(suffixDivider));
            dividend +=  "" + (Integer.valueOf(divisible) / Integer.valueOf(suffixDivider));

        }


        return 0;
    }

    public static void main( String args[])
    {
        double[] inputs = {2, 4, 101};
        double[] expected_values = { 1.41421, 2, 10 };
        double threshold = 0.001;
        for(int i=0; i < inputs.length; i++)
        {
            if( Math.abs(squareRoot(inputs[i])-expected_values[i])>threshold )
            {
                System.out.printf( "Test failed for %f, expected=%f, actual=%f\n", inputs[i], expected_values[i], squareRoot(inputs[i]) );
            }
        }
        System.out.println( "All tests passed");
    }
}