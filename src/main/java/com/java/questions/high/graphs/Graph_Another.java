package com.java.questions.high.graphs;

import java.util.*;

public class Graph_Another implements Graph {

    int[][] adj;
    int[][] weights;

    int totalNodes;
    List<Node> nodes = new ArrayList<>();
    Map<String, Node> nodeMap = new LinkedHashMap<>();

    public Graph_Another(int totalNodes){
        this.totalNodes = totalNodes;
        adj  = new int[totalNodes][totalNodes];
        weights  = new int[totalNodes][totalNodes];
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

        Set<Integer> visited = new LinkedHashSet<>();
        visited.add(start);
        List<Integer> vertices = new ArrayList<>();

        for (int i =0 ; i < adj.length; i++){
            if (adj[start][i] == 1){
                vertices.add(i);
            }
        }
        BFS(visited, vertices);

        for (Integer integer : visited){
            System.out.print(integer + " -> ");
        }


    }

    public void BFS(Set<Integer> visited, List<Integer> vertices){

        for (Integer integer : vertices){
            visited.add(integer);
        }

        List<Integer> childVertices = new ArrayList<>();

        for (Integer integer : vertices){
            for (int i =0 ; i < adj.length; i++){
                if (adj[integer][i] == 1){
                    childVertices.add(i);
                }
            }
            BFS(visited, childVertices);
        }

        return;
    }

    @Override
    public void DFS(int start) {

        Set<Integer> visited = new LinkedHashSet<>();
        visited.add(start);
        List<Integer> vertices = new ArrayList<>();

        for (int i =0 ; i < adj.length; i++){
            if (adj[start][i] == 1){
                vertices.add(i);
            }
        }

        DFS(visited, vertices);

        for (Integer integer : visited){
            System.out.print(integer + " -> ");
        }

    }

    public void DFS(Set<Integer> visited, List<Integer> vertices){

        for (Integer integer : vertices){

            if (!visited.contains(integer)){
                visited.add(integer);

                List<Integer> childVertices = new ArrayList<>();

                    for (int i =0 ; i < adj.length; i++){
                        if (adj[integer][i] == 1){
                            childVertices.add(i);
                        }
                    }
                    DFS(visited, childVertices);
            }
        }
        return;
    }

    @Override
    public void printGraph() {

        System.out.println("====adj====");
        for (int[] ints : adj){
            System.out.println("======");
            for (int i : ints){
                System.out.print(i + " ");
            }

        }

        System.out.println("====weights====");
        for (int[] ints : weights){
            System.out.println("======");
            for (int i : ints){
                System.out.print(i + " ");
            }

        }

    }

    @Override
    public void setShortestPath(int start, boolean longest) {

    }
}
