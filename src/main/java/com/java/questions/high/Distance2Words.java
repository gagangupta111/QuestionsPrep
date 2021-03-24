package com.java.questions.high;

public class Distance2Words {

    // Input two words returns the shortest distance between their two midpoints in number of characters
    // Words can appear multiple times in any order and should be case insensitive.

    // E.g. for the document="Example we just made up"
    //   shortestDistance( document, "we", "just" ) == 4

    public static double shortestDistance(String document, String word1, String word2) {
        double shortest = document.length();

        int i = 0;
        int word1_start = 0;
        int word2_start = 0;

        for (; i < document.length() - word1.length(); i++){

            if (document.substring(i, i + word1.length()).equalsIgnoreCase(word1)){
                break;
            }

        }
        word1_start = i;

        for ( i = i + word1.length(); i < document.length() - word2.length(); i++){

            if (document.substring(i, i + word2.length()).equalsIgnoreCase(word2)){
                break;
            }

        }
        word2_start = i;

        word1_start += word1.length()/2;
        word2_start += word2.length()/2;

        return word2_start - word1_start;
    }

    public static boolean pass() {
        return  shortestDistance(document, "and", "graphic") == 6d &&
                shortestDistance(document, "transfer", "it") == 14d &&
                shortestDistance(document, "Design", "filler" ) == 25d ;
    }

    public static void main(String[] args) {
        if (pass()) {
            System.out.println("Pass");
        } else {
            System.out.println("Some Fail");
        }
    }

    private static final String document;

    static{

        StringBuffer sb = new StringBuffer();
        sb.append("In publishing and graphic design, lorem ipsum is a filler text commonly used to demonstrate the graphic elements");
        sb.append(" lorem ipsum text has been used in typesetting since the 1960s or earlier, when it was popularized by advertisements");
        sb.append(" for Letraset transfer sheets. It was introduced to the Information Age in the mid-1980s by Aldus Corporation, which");

        document = sb.toString();

    }

}
