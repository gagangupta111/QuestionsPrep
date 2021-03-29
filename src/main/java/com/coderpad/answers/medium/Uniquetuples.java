package com.coderpad.answers.medium;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Uniquetuples {

    public static Set<String> uniqueTuples( String input, int len ) {

        Set<String> set = new LinkedHashSet<>();
        if (len >= input.length()){
            set.add(input);
            return set;
        }

        for (int i = 0 ; i + len <= input.length(); i++ ){

            set.add(input.substring(i, i+len));

        }

        return set;

    }

    public static void main( String[] args ) {

        boolean pass = true;

        String input = "aab";
        Set<String> result = uniqueTuples( input, 2 );

        pass = pass && result.contains( "aa" ) && result.contains( "ab" );

        input = "aabb";
        result = uniqueTuples( input, 2 );

        pass = pass && result.contains( "aa" ) && result.contains( "bb" );

        input = "aabbcc";
        result = uniqueTuples( input, 2 );

        pass = pass && result.contains( "ab" ) && result.contains( "bc" );
        if( pass ) {
            System.out.println( "Test passed." );

        } else {
            System.out.println( "Test failed." );

        }
    }
}
