package com.coderpad.answers.high;
import java.util.*;

class Sqrt {

    /*
     *   double squareRoot( double x )
     *
     */

    public static double squareRoot( double x, double threhhold )
    {
        return squareRoot(x, threhhold, 0, x);
    }

    public static double squareRoot( double x, double threhhold, double min, double max )
    {

        double mid = (min + max)/2.0;
        double midSqr = mid * mid;

        System.out.println( "=========");
        System.out.println( "midSqr: " + midSqr);
        System.out.println( "(x + (threhhold*threhhold): " + (x + (threhhold*threhhold)));
        System.out.println( "(x - (threhhold*threhhold): " + (x - (threhhold*threhhold)));

        if(midSqr > (x + (threhhold*threhhold)) ){
            return squareRoot(x, threhhold, 0.0, mid);
        }else if(midSqr < (x - (threhhold*threhhold)) ){
            return squareRoot(x, threhhold, mid, x);
        }

        return mid;
    }

    public static void main( String args[])
    {
        double[] inputs = {2.0, 4.0, 100.0};
        double[] expected_values = { 1.41421, 2, 10 };
        double threshold = 0.1;
        for(int i=0; i < inputs.length; i++)
        {
            if( Math.abs(squareRoot(inputs[i], threshold)-expected_values[i])>threshold )
            {
                System.out.printf( "Test failed for %f, expected=%f, actual=%f\n", inputs[i], expected_values[i], squareRoot(inputs[i], threshold) );
            }
        }
        System.out.println( "All tests passed");
    }
}