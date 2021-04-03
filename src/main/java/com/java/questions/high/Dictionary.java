package com.java.questions.high;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dictionary {

    public static void main(String[] args){

        List<String> list = new ArrayList<>();
        permutations(list, "", "abd");
        Collections.sort(list, (s1, s2) -> s2.length() - s1.length());
        for (String s : list){

            System.out.println(s);

        }

    }

    private static void permutations(List<String> list, String perm, String word) {

        if (!perm.isEmpty()) {
            list.add(perm);
        }

        if (!word.isEmpty()) {
            for (int i = 0; i < word.length(); i++) {
                permutations(list, perm + word.charAt(i), word.substring(0, i) + word.substring(i + 1));
            }
        }
    }


}


