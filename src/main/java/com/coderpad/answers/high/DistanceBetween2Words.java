package com.coderpad.answers.high;

public class DistanceBetween2Words {

    // Input two words returns the shortest distance between their two midpoints in number of characters
    // Words can appear multiple times in any order and should be case insensitive.

    // E.g. for the document="Example we just made up"
    //   shortestDistance( document, "we", "just" ) == 4

    // 9:57


    public static double shortestDistance(String document, String word1, String word2) {

        document = document.toLowerCase();
        word1 = word1.toLowerCase();
        word2 = word2.toLowerCase();

        int word1Index = 0;
        int i = 0;
        for ( ; i + word1.length() < document.length(); i++){
            if (document.substring(i, i + word1.length()).equals(word1)){
                break;
            }
        }
        word1Index = i;
        int j = word1Index + word1.length();

        for (; j + word2.length() < document.length(); j++){
            if (document.substring(j, j + word2.length()).equals(word2)){
                break;
            }
        }

        int word2Index = j;
        int med = word2Index + word2.length()/2 - word1Index - word1.length()/2;


        return med;
    }

    public static boolean pass() {
        return  shortestDistance(document, "and", "graphic") == 6.0 &&
                shortestDistance(document, "transfer", "it") == 14.0 &&
                shortestDistance(document, "Design", "filler" ) == 25.0 ;
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