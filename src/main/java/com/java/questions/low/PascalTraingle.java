package com.java.questions.low;

import java.util.LinkedList;
import java.util.List;

public class PascalTraingle {

    public static  int pascalMatrix(int col, int row){

        int n = row+1;
        if (row == 0){
            return 1;
        }
        // An auxiliary array to store generated pascal triangle values
        int[][] arr = new int[n][n];

        // Iterate through every line and print integer(s) in it
        for (int line = 0; line < n; line++)
        {
            // Every line has number of integers equal to line number
            for (int i = 0; i <= line; i++)
            {
                // First and last values in every row are 1
                if (line == i || i == 0)
                    arr[line][i] = 1;
                else // Other values are sum of values just above and left of above
                    arr[line][i] = arr[line-1][i-1] + arr[line-1][i];
            }
        }
        return arr[row][col];
    }

    public static  int pascal(int col, int row){

        List<Integer> lineIntegers = new LinkedList<>();
        for(int line = 1; line <= row; line++)
        {
            int C=1;// used to represent C(line, i)
            for(int i = 1; i <= line; i++)
            {
                C = C * (line - i) / i;
                if (line == row){
                    lineIntegers.add(C);
                }
            }
        }
        if (row == 0){
            return 1;
        }
        return lineIntegers.get(col);
    }

    public static void main(String[] args) {

        if(PascalTraingle.pascalMatrix(0,0) ==  1 &&
                PascalTraingle.pascalMatrix(1,2) ==  2 &&
                PascalTraingle.pascalMatrix(5,6) ==  6 &&
                PascalTraingle.pascalMatrix(4,8) ==  70 &&
                PascalTraingle.pascalMatrix(6,6) ==  1) {
            System.out.println("Pass");
        }else {
            System.out.println("Failed");
        }
    }

}
