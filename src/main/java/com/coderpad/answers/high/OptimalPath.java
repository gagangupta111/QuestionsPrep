package com.coderpad.answers.high;


/*
 ** Instructions to candidate.
 **  1) You are an avid rock collector who lives in southern California. Some rare
 **     and desirable rocks just became available in New York, so you are planning
 **     a cross-country road trip. There are several other rare rocks that you could
 **     pick up along the way.
 **
 **     You have been given a grid filled with numbers, representing the number of
 **     rare rocks available in various cities across the country.  Your objective
 **     is to find the optimal path from So_Cal to New_York that would allow you to
 **     accumulate the most rocks along the way.
 **
 **     Note: You can only travel either north (up) or east (right).
 **  2) Consider adding some additional tests in doTestsPass().
 **  3) Implement optimalPath() correctly.
 **  4) Here is an example:
 **                                                           ^
 **                 {{0,0,0,0,5}, New_York (finish)           N
 **                  {0,1,1,1,0},                         < W   E >
 **   So_Cal (start) {2,0,7,0,0}}                             S
 **                                                           v
 **   The total for this example would be 10 (2+0+1+1+1+0+5).
 */

import java.util.*;

public class OptimalPath
{

    public static Integer optimalPath(Integer[][] grid) {

        int[][] sumGrid = new int[grid.length][grid[0].length];

        sumGrid[sumGrid.length-1][0] = grid[grid.length-1][0];

        resetDistances(sumGrid.length-1, 0, sumGrid, grid);

        return sumGrid[0][sumGrid[0].length-1];

    }

    public static void resetDistances(int x, int y, int[][] sumGrid, Integer[][] grid){

        int minRow = 0;
        int maxCol = grid[0].length-1;

        {
            int upX = x-1;
            int upY = y;
            if (upX >= minRow && upY <= maxCol) {

                if (sumGrid[x][y] + grid[upX][upY] > sumGrid[upX][upY]) {
                    sumGrid[upX][upY] = sumGrid[x][y] + grid[upX][upY];
                    resetDistances(upX, upY, sumGrid, grid);
                }

            }
        }

        {
            int rightX = x;
            int rightY = y+1;
            if (rightX >= minRow && rightY <= maxCol) {

                if (sumGrid[x][y] + grid[rightX][rightY] > sumGrid[rightX][rightY]) {
                    sumGrid[rightX][rightY] = sumGrid[x][y] + grid[rightX][rightY];
                    resetDistances(rightX, rightY, sumGrid, grid);
                }

            }
        }


    }

    private static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static boolean doTestsPass()
    {
        boolean result = true;
        result &= optimalPath(new Integer[][]{{0,0,0,0,5},
                {0,1,1,7,0},
                {2,0,0,10,0}}) == 24;
        return result;
    }

    public static void main(String[] args)
    {
        if(doTestsPass())
        {
            System.out.println("All tests pass");
        }
        else
        {
            System.out.println("Tests fail.");
        }
    }
}