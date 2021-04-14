package com.coderpad.answers.low;

public class SquareRoot {

    /*
     *   double squareRoot( double x )
     *
     */

    private static double findSqrt(double x, double threshold, double min, double max) {

        double mid = (max + min) / 2;
        double midsq = mid*mid;

        if(midsq < x + threshold*threshold && midsq > x - threshold*threshold) {
            return mid;
        }
        else if( midsq > x + threshold*threshold) {
            return findSqrt(x, threshold, min, mid);
        }
        else {
            return findSqrt(x, threshold, mid, max);
        }
    }

    public static double squareRoot( double x, double threshold )
    {
        return findSqrt(x, threshold, 0, x);
    }

    public static void main( String args[])
    {
        double[] inputs = {2, 4, 100};
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