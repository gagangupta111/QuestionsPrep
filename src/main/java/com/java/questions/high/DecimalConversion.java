package com.java.questions.high;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class DecimalConversion {

    public static String fractionRepresentation(  String decimals, int startIndex ) {

        int[] arr = new int[decimals.length()];

        for (int i = 0; i < decimals.length(); i++){
            arr[i] = Integer.valueOf(decimals.charAt(i) + "");
        }

        Map<String, Integer> outerMap = new LinkedHashMap<>();

        for (int i =0 ; i < arr.length; i++){

            String s = "";
            Set<String> innerSet = new LinkedHashSet<>();

            for (int j = i; j < arr.length; j++){

                if (!innerSet.contains("" + arr[j])){
                    innerSet.add("" + arr[j]);
                    s += arr[j];
                    if (outerMap.get(s) == null){
                        outerMap.put(s, 1);
                    }else {
                        outerMap.put(s, outerMap.get(s) + 1);
                    }
                }else {
                    break;
                }
            }
        }

        int maxLength = 0;
        int maxTimes = 0;
        String key = "";

        for (Map.Entry<String, Integer> entry : outerMap.entrySet()){
            if (entry.getKey().length() > maxLength){
                maxLength = entry.getKey().length();
                key = entry.getKey();
                maxTimes = entry.getValue();
            }
        }

        String finalString = "";
        for (Integer integer : arr){
            finalString += "" + integer;
        }

        if (maxLength == arr.length){
            return finalString;
        }

        if (maxLength*maxTimes > arr.length*(2/3.0)){
            return "(" + key + ")";
        }

        return finalString;
    }

    public static String precisionCompute(int x, int y, int n)
    {
        String finalString = "";
        // Base cases
        if (y == 0) {
            return null;
        }
        if (x == 0) {
            return "0";
        }
        if (n <= 0) {
            // Since n <= 0, don't compute after
            // the decimal
            return "" + x / y;
        }

        // Handling negative numbers
        if (((x > 0) && (y < 0)) || ((x < 0) && (y > 0))) {
            System.out.print("-");
            x = x > 0 ? x : -x;
            y = y > 0 ? y : -y;
        }

        // Integral division
        int d = x / y;

        // Now one by print digits after dot
        // using school division method.
        for (int i = 0; i <= n; i++) {
            finalString += d;
            x = x - (y * d);
            if (x == 0)
                break;
            x = x * 10;
            d = x / y;
            if (i == 0)
                finalString += ".";
        }

        return finalString;
    }

    public static void main(String args[]) {

        boolean pass = true;

        String result  = precisionCompute(1,3, 20);
        System.out.println(result);
        pass = pass && fractionRepresentation(result.split("\\.")[1], 0).equalsIgnoreCase("(3)");

        result  = precisionCompute(500,32, 50);
        System.out.println(result);
        pass = pass && fractionRepresentation(result.split("\\.")[1], 0).equalsIgnoreCase("625");

        result  = precisionCompute(5,2, 50);
        System.out.println(result);
        pass = pass && fractionRepresentation(result.split("\\.")[1], 0).equalsIgnoreCase("5");

        result  = precisionCompute(22,7, 50);
        System.out.println(result);
        pass = pass && fractionRepresentation(result.split("\\.")[1], 0).equalsIgnoreCase("(142857)");

        result  = precisionCompute(20,3, 50);
        System.out.println(result);
        pass = pass && fractionRepresentation(result.split("\\.")[1], 0).equalsIgnoreCase("(6)");

        if (pass){
            System.out.println("All pass");
        }else {
            System.out.println("Something failed");
        }


    }

}
