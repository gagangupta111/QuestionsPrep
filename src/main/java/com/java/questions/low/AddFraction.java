package com.java.questions.low;

public class AddFraction {

    /**
     * Given two fractions passed in as int arrays,
     * returns the fraction which is result of adding the two input fractions.
     */
    public static int[] addFractions( int[] fraction1, int[] fraction2 ) {
        // Write your code here

        if(fraction1 == null || fraction2 == null){
            throw new IllegalArgumentException("Illegal Arguments");
        }

        if(fraction1[0] == 0 || fraction2[0] == 0){
            throw new IllegalArgumentException("Illegal Arguments");
        }


        int ground = 0;
        int upper = 0;
        int gcd = 1;

        upper += ( fraction1[0] *  fraction2[1] ) +  ( fraction1[1] *  fraction2[0] );
        ground += ( fraction1[1] *  fraction2[1] ) ;


        for (int i = 1; i <= ground && i <= upper; i++){

            if(ground % i == 0 && upper % i == 0){
                gcd = i;
            }

        }

        ground = ground / gcd;
        upper = upper / gcd;


        return ( new int[]{ upper, ground } );
    }


    public static void main( String[] args ) {
        int[] result = addFractions( new int[]{ 2, 3 }, new int[]{ 1, 2 } );

        if( result[ 0 ] == 7 && result[ 1 ] == 6 ) {
            System.out.println( "Test passed." );
        } else {
            System.out.println( "Test failed." );
        }
    }
}