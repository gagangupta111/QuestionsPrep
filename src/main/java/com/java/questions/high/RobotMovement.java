package com.java.questions.high;

import java.util.Arrays;

public class RobotMovement {

    public static void test(){

        for (int i = 0; i < 5; i++){
            switch ('B'){

                case 'A':
                    System.out.println("A");
                    break;
                case 'B':
                    System.out.println("B");
                    break;
                case 'C':
                    System.out.println("C");
                    break;
                default:
                    System.out.println("Default");
            }
        }
    }

    public static Integer[] walk( String path ) {

        Integer[] initial  = {0,0};
        for (int i = 0 ; i < path.length(); i++){

            switch (path.charAt(i)){

                case 'U':
                    initial[1] += 1;
                    break;
                case 'D':
                    initial[1] += -1;
                    break;
                case 'L':
                    initial[0] += -1;
                    break;
                case 'R':
                    initial[0] += 1;
                    break;
                default:
                    System.out.println("Default");
            }
        }

        return initial;

    }

    public static boolean isEqual(Integer[] a, Integer[] b) {

        return Arrays.equals(a, b);
    }

    public static boolean pass() {
        boolean res = true;

        {
            String test = "DDD";
            Integer[] result = walk(test);
            res &= isEqual(result, new Integer[]{0, -3});
        }

        {
            String test = "UUU";
            Integer[] result = walk(test);
            res &= isEqual(result, new Integer[]{0, 3});
        }

        {
            String test = "ULDR";
            Integer[] result = walk(test);
            res &= isEqual(result, new Integer[]{0, 0});
        }

        {
            String test = "ULLLDUDUURLRLR";
            Integer[] result = walk(test);
            res &= isEqual(result, new Integer[]{-2, 2});
        }

        return res;
    }

    public static void main(String[] args) {

        test();

        if(pass()){
            System.out.println("{Pass");
        } else {
            System.out.println("Test failures");
        }
    }

}
