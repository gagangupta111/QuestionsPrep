package com.java.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tes {

    public static void main(String[] args){

        int i = -2;
        int j = -9;
        System.out.println(i + j);

        System.out.println(Math.abs(i+j));

        System.out.println("substring::");

        System.out.println(Arrays.toString("a.b.c.de".split("\\.")));


        switch ("B"){

            case "A":
                System.out.println("A");
                break;
            case "B":
                System.out.println("B");
                break;

        }

    }

}
