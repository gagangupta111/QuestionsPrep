package com.java.questions;

import java.util.ArrayList;
import java.util.List;

public class Tes {

    public static void main(String[] args){


        Object o = 10.0;

        if (o instanceof Double){
            System.out.println("True");
        }

        System.out.println(5/2);
        System.out.println(5/2.0);


        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println(list);

        list.remove(new Integer(2));

        System.out.println(list);


    }

}
