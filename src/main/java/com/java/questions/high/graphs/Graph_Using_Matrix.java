package com.java.questions.high.graphs;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Graph_Using_Matrix implements Graph {


    int[][] adj;
    int[][] weights;
    int[][] shortestPath;
    List<Node> nodes = new ArrayList<>();
    int totalNodes;

    public Graph_Using_Matrix(int totalNodes) {

        this.totalNodes = totalNodes;
        adj = new int[totalNodes][totalNodes];
        weights = new int[totalNodes][totalNodes];
    }

    public void setShortestPath(int start, boolean longest){

        int[] distances = new int[totalNodes];

        for (int i = 0 ; i < distances.length; i++){
            if (longest){
                distances[i] = Integer.MIN_VALUE;
            }else {
                distances[i] = Integer.MAX_VALUE;
            }
        }
        distances[start] = 0;

        // reset above
        // get all vertices of start index and reset the initial distances
        int[] temp = adj[start];
        for (int i = 0; i < totalNodes; i++){
            if (temp[i] == 1){
                distances[i] = weights[start][i];
            }
        }

        // init complete above
        setShortestPath(distances, start, longest);
        System.out.println("======setShortestPath=======");

        for (int i = 0; i < distances.length; i++){
            System.out.println(i + " : " + distances[i]);
        }
    }

    public void setShortestPath(int[] distances, int currentVertex, boolean longest){

        // get all vertex of current vertex

        for (int i = 0; i < totalNodes; i++){
            if (adj[currentVertex][i] == 1){
                int initialDistance = distances[i];
                int newDistance = distances[currentVertex] + weights[currentVertex][i];
                if (longest){
                    if (newDistance > initialDistance){
                        distances[i] = newDistance;
                    }
                }else {
                    if (newDistance < initialDistance){
                        distances[i] = newDistance;
                    }
                }
            }
        }

        for (int i = 0; i < totalNodes; i++){
            if (adj[currentVertex][i] == 1){
                setShortestPath(distances, i, longest);
            }
        }
    }

    @Override
    public void addEdge(int from, int to) {

        adj[from][to] = 1;

    }

    @Override
    public void addEdge(int from, int to, int weight) {
        adj[from][to] = 1;
        weights[from][to] = weight;

    }

    @Override
    public void BFS(int start) {

        int[] vertices = adj[start];
        List<Integer> verticesList = new ArrayList<>();
        Set<Integer> visited = new LinkedHashSet<>();

        for (int i = 0; i< vertices.length; i++){
            if (vertices[i] == 1){
                verticesList.add(i);
            }
        }
        BFS(visited, verticesList);

        for (Integer integer : visited){
            System.out.println(integer);
        }
    }

    @Override
    public void DFS(int start) {

        int[] vertices = adj[start];
        List<Integer> verticesList = new ArrayList<>();
        Set<Integer> visited = new LinkedHashSet<>();

        for (int i = 0; i< vertices.length; i++){
            if (vertices[i] == 1){
                verticesList.add(i);
            }
        }
        DFS(visited, verticesList);

        for (Integer integer : visited){
            System.out.println(integer);
        }

    }

    public void BFS(Set<Integer> visited , List<Integer> vertices) {

        List<Integer> verticesList = new ArrayList<>();
        for (Integer integer : vertices){

            if (!visited.contains(integer)){
                visited.add(integer);
            }else {
                continue;
            }
        }
        for (Integer integer : vertices){

            verticesList = new ArrayList<>();
            int[] array = adj[integer];

            for (int i = 0; i< array.length; i++){
                if (array[i] == 1){
                    verticesList.add(i);
                }
            }
            BFS(visited, verticesList);

        }
        return;
    }

    public void DFS(Set<Integer> visited , List<Integer> vertices) {

        for (Integer integer : vertices){

            if (!visited.contains(integer)){
                visited.add(integer);
            }else {
                continue;
            }
            List<Integer> verticesList = new ArrayList<>();
            int[] array = adj[integer];

            for (int i = 0; i< array.length; i++){
                if (array[i] == 1){
                    verticesList.add(i);
                }
            }

            DFS(visited, verticesList);
        }
        return;
    }

    @Override
    public void printGraph() {

        System.out.println("====adj====");
        for (int[] ints : adj){
            System.out.println();
            for (int i : ints){
                System.out.print(i + ",");
            }
        }

        System.out.println("====weights====");
        for (int[] ints : weights){
            System.out.println();
            for (int i : ints){
                System.out.print(i + ",");
            }
        }



    }
}
