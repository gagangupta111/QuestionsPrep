package com.java.questions;

import com.coderpad.answers.high.LongestTreeDummy;

import java.util.*;
import java.util.stream.Collectors;

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


        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(11);
        list.add(12);
        list.add(13);
        list.add(14);
        list.add(15);
        list.add(16);
        list.add(17);

        list.stream().forEach((n) -> System.out.println("__" + n + 1));

        Map<Integer, Integer> map = new HashMap<>();
        map.put(12, 12);
        map.put(11, 11);
        map.put(10, 10);
        map.put(13, 13);
        map.put(14, 14);
        map.put(15, 15);
        map.put(16, 16);

        map.entrySet().stream().forEach(n -> System.out.println(n.getKey() + "_+_" + n.getValue()));


        int[] ints = new int[]{1,2,3};
        Arrays.stream(ints).forEach(System.out::println);


        String[] strings = new String[]{"a", "b", "c"};
        Arrays.stream(strings).forEach(System.out::println);

        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);

        System.out.println("GHGFFGJJGHFHJHGHFJHGHFDHGJHJ");

        Collection<Integer> collection = set;
        collection.stream().filter((n) -> n > 3).sorted(Collections.reverseOrder()).map((n) -> "_+_" + n).collect(Collectors.toList()).forEach((n) -> {
            System.out.println(n);
        });

        System.out.println("gshaggdhf");
        Collection<Map.Entry<Integer, Integer>> collctionssdsd  = map.entrySet();
        //
        // collctionssdsd.stream().reduce((s1, s2) -> s1.getKey() + "" + s2.getKey())

        String s = "abcd";

        final Character c = null;
        int maxLength = 0;

        Double aDouble = Math.random()*1000/34.00;
        System.out.println("Random : " + aDouble);


        System.out.println(("abcd".split("x"))[0]);

        int number = -1;
        System.out.println(number);

        number = -number;
        System.out.println(number);

    }

}
