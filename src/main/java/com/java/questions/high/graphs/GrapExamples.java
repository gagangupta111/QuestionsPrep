package com.java.questions.high.graphs;

import java.util.*;


/*

     0 > 1
     1 > 2
     2 > 3
     3 > 4

     0 > 4
     0 > 5

              ->1   [7]      3
            [2]                 [1]
         0     [1]          [2]     5
            [4]                 [5]
              ->2   [3]      4


 */



public class GrapExamples {

    public static void main(String[] args){

        Graph graphUsingList = new Graph_Another(6);
        System.out.println("Initiated Graph_Using_List!");
        graphUsingList.printGraph();

        graphUsingList.addEdge(0,1, 2);
        graphUsingList.addEdge(0,4, 4);
        graphUsingList.addEdge(0,5, 1);

        graphUsingList.addEdge(1,2, 1);
        graphUsingList.addEdge(2,3, 1);
        graphUsingList.addEdge(3,4, 1);
        graphUsingList.addEdge(4,5, 1);

        System.out.println("Added edges");
        graphUsingList.printGraph();

        System.out.println("===DFS==");
        graphUsingList.DFS(0);

        System.out.println("==BFS===");
        graphUsingList.BFS(0);

        System.out.println("==setShortestPath===longest=====");
        graphUsingList.setShortestPath(0, true);

        System.out.println("==setShortestPath===shortest=====");
        graphUsingList.setShortestPath(0, false);
    }

    public void graphWithNames(){

        Graph graphUsingList = new Graph_Another(6);
        System.out.println("Initiated Graph_Using_List!");
        graphUsingList.printGraph();

        graphUsingList.addEdge(0,1, 2);
        graphUsingList.addEdge(0,4, 4);
        graphUsingList.addEdge(0,5, 1);

        graphUsingList.addEdge(1,2, 1);
        graphUsingList.addEdge(2,3, 1);
        graphUsingList.addEdge(3,4, 1);
        graphUsingList.addEdge(4,5, 1);

    }

}
