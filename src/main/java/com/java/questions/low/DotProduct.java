package com.java.questions.low;

public class DotProduct {

    public static int dotProduct( int[] array1, int[] array2 ) {

        int product = 0;

        for (int i = 0; i < array1.length; i++){

            product += array1[i] * array2[i];

        }

        return product;
    }

    public static void main( String[] args ) {

        int[] array1 = { 1, 2, 3 };
        int[] array2 = { 2, 3, 5 };
        int result = dotProduct( array1, array2 );

        if( result == 23 ) {
            System.out.println( "Passed." );
        } else {
            System.out.println( "Failed." );
        }



    }

}
