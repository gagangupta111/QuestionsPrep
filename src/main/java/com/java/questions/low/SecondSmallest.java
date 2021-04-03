package com.java.questions.low;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/*


public static int secondSmallest(int[] arr) {
      if (arr == null || arr.length <= 1) {
       return -1;
}
      int firstSmallest = Integer.MAX_VALUE;
      int secondSmallest = Integer.MAX_VALUE;
      for (int i = 0; i < arr.length; i++) {
       if (arr[i] < firstSmallest) {
          secondSmallest = firstSmallest;
          firstSmallest = arr[i];
   } else if (arr[i] < secondSmallest && arr[i] != firstSmallest) {
          secondSmallest = arr[i];
   }
}
      if (secondSmallest == Integer.MAX_VALUE) {
       return -1;
}
      return secondSmallest;
  }


 */

public class SecondSmallest {

    public static int secondSmallest(int[] x) {

        int firstSmallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int i : x){

            if (i <= firstSmallest){
                secondSmallest = firstSmallest;
                firstSmallest = i;
            }else if (i >= firstSmallest && i <= secondSmallest){
                secondSmallest = i;
            }

        }

        if (secondSmallest == Integer.MAX_VALUE){
            return firstSmallest;
        }

        return secondSmallest;

    }

    public static void main(String args[]) {

        int[] a = { 0 };
        int[] b = { 0, 1 };
        int[] c = { 0, 0, 2 };
        int[] d = { 0, 0, 0 };
        int[] e = { 0, 2, 1 };
        int[] f = { 0, 5, 5 };

        boolean result = true;
        result &= secondSmallest(a) == 0;
        result &= secondSmallest(b) == 1;
        result &= secondSmallest(c) == 0;
        result &= secondSmallest(d) == 0;
        result &= secondSmallest(f) == 5;

        if (result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }

    }

}
