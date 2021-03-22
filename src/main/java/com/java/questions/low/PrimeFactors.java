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
        if (n % 2 == 0 ||
                n % 3 == 0)
            return false;

        for (int i = 5;
             i * i <= n; i = i + 6)
            if (n % i == 0 ||
                    n % (i + 2) == 0)
                return false;

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

        for (Integer integer : primeFactorization(122)){
            System.out.print(integer + " , ");
        }

    }

}
