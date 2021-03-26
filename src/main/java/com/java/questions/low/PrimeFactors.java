package com.java.questions.low;

import java.util.*;

public class PrimeFactors {

    static List<Integer> allPrimesBelowN(int n)
    {

        List<Integer> allPrimes = new ArrayList<>();
        for (int i = 2; i <= n; i++)
        {
            if (isPrime(i))
                allPrimes.add(i);
        }

        return allPrimes;
    }

    public static boolean isPrimeSimpler(int n)
    {

        if (n < 1){
            return false;
        }

        for (int i = 2; i <= n/2; i++){

            if (n % i == 0){
                return true;
            }

        }
        return false;
    }


    public static boolean isPrime(int n)
    {
        // Corner cases
        if (n <= 1)
            return false;
        if (n <= 3)
            return true;

        // This is checked so
        // that we can skip
        // middle five numbers
        // in below loop
        for (int i = 2; i <= n/2; i++){

            if (n % i == 0){
                return false;
            }

        }
        return true;
    }

    public static List<Integer> primeFactorization(int x)
    {

        List<Integer> factors = new ArrayList<>();
        List<Integer> allPrimes  = allPrimesBelowN(x);
        for (Integer prime : allPrimes ){

            if (x % prime == 0){
                factors.add(prime);
                factors.addAll(primeFactorization(x / prime));
                break;
            }

        }

        return factors;
    }

    public static void main(String args[])
    {

        boolean result = true;
        result &= primeFactorization(6).contains(2);
        result &= primeFactorization(6).contains(3);
        result &= !primeFactorization(6).contains(4);
        result &= !primeFactorization(6).contains(5);


        result &= primeFactorization(8).contains(2);
        result &= primeFactorization(25).contains(5);
        result &= primeFactorization(20).contains(2);
        result &= primeFactorization(20).contains(5);

        if (result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }

    }

}
