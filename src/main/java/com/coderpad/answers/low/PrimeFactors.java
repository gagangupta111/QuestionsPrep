package com.coderpad.answers.low;

import java.io.*;
        import java.util.*;

public class PrimeFactors
{
    /**
     * Return an array containing prime numbers whose product is x
     * Examples:
     * primeFactorization( 6 ) == [2,3]
     * primeFactorization( 5 ) == [5]
     */

    public static boolean checkPrime(int x ){

        if(x <= 1){
            return false;
        }

        if(x <= 3){
            return true;
        }

        for ( int i  = 2; i <= x/2; i++){

            if( x % i == 0){

                return false;
            }

        }

        return true;

    }

    public static List<Integer> primeFactorization(int x)
    {

        List<Integer> allPrimes = new ArrayList<>();
        List<Integer> finalAllPrimes = new ArrayList<>();

        for( int i = 2; i <= x; i++){

            if(checkPrime(i)){
                allPrimes.add(i);
            }
        }

        int divisible = x;

        while (divisible != 1){

            int divider = divide(divisible, allPrimes);
            finalAllPrimes.add(divider);
            divisible = divisible / divider;

        }

        return finalAllPrimes;

    }


    public static int divide(int x, List<Integer> allprimes){

        for(Integer integer : allprimes){

            if( x % integer == 0){
                return integer;
            }

        }

        return x;

    }

    public static void main(String args[])
    {

        System.out.println(primeFactorization(6) + " " + primeFactorization(5));
        if(primeFactorization(6).equals(Arrays.asList(2,3))
                &&
                primeFactorization(5).equals(Arrays.asList(5))
                ) {
            System.out.println("All passed");
        }else {
            System.out.println("Failed");
        }

    }
}
