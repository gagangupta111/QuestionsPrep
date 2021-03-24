package com.java.questions.medium;

import java.util.*;

public class UniqueTuplesGivenSize {

    public static HashSet<String> uniqueTuples(String input, int len ) {

        HashSet<String> set = new LinkedHashSet<>();
        if (len > input.length()){
            return set;
        }

        for (int i = 0; i <= input.length() - len; i++){

            set.add(input.substring(i, i+2));

        }

        return set;

    }

    public static void main( String[] args ) {

        String input = "aab";

        boolean pass = true;

        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("ab");
        hashSet.add("aa");
        pass = pass && uniqueTuples( "aab", 2 ).containsAll(hashSet) ;

        hashSet = new HashSet<>();
        hashSet.add("ab");
        hashSet.add("aa");
        hashSet.add("ba");
        pass = pass && uniqueTuples( "aaba", 2 ).containsAll(hashSet) ;

        hashSet = new HashSet<>();
        hashSet.add("xy");
        hashSet.add("yz");
        pass = pass && uniqueTuples( "xyz", 2 ).containsAll(hashSet) ;

        hashSet = new HashSet<>();
        hashSet.add("ab");
        hashSet.add("bc");
        pass = pass && uniqueTuples( "abcde", 2 ).containsAll(hashSet) ;

        if( pass) {
            System.out.println( "Test passed." );

        } else {
            System.out.println( "Test failed." );

        }
    }

}
