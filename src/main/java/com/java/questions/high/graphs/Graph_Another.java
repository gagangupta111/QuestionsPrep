package com.java.questions.high.graphs;

import java.util.*;

public class Graph_Another implements Graph {

    public int[][] adj;
    public int[][] weights;

    public int totalNodes;

    // get node for an index
    public List<Node> nodes = new ArrayList<>();

    // get index for a node
    public Map<String, Integer> nodeIndexMap = new LinkedHashMap<>();

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

        System.out.println();
        for (int i = 0 ; i < nodes.size(); i++){

            System.out.println("Index: " + i + ", Name: " + nodes.get(i).name);

        }

    }

    @Override
    public void setShortestPath(int start, boolean longest) {

        int[] distances = new int[adj.length];
        Set<Integer> visited = new LinkedHashSet<>();
        List<List<String>> paths = new ArrayList<>();

        for (int i = 0; i < adj.length; i++){
            paths.add(new ArrayList<>());
            if (weights[start][i] == 0){
                distances[i] =  longest ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }else {
                distances[i] = weights[start][i];
                paths.get(i).add(nodes.get(start).name);
                paths.get(i).add(nodes.get(i).name);
            }
        }
        distances[start] = 0;

        setShortestPath(distances, visited, paths, longest);

        System.out.println();
        for (int i = 0; i < distances.length; i++){

            System.out.println();
            System.out.println("Distance from : " + nodes.get(start).name + " to : " + nodes.get(i).name + " is : " + distances[(i)]);
            System.out.println("Paths from : " + nodes.get(start).name + " to : " + nodes.get(i).name + " is : " + paths.get(i));

        }

    }

    public int get_Smallest_Distanced_Non_Visited_Index(int[] distances,  Set<Integer> visited){

        Map<Integer, Integer> sortedMap = new LinkedHashMap<>();
        for (int i  = 0 ; i < distances.length; i++){
            if (visited.contains(i)){
                continue;
            }
            sortedMap.put(distances[i], i);
        }

        int smallestDistance = Integer.MAX_VALUE;
        int smallestIndex = -1;
        for (Integer integer : sortedMap.keySet()){
            if (integer < smallestDistance && !visited.contains(sortedMap.get(integer))){
                smallestDistance = integer;
                smallestIndex = sortedMap.get(integer);
            }
        }

        return smallestIndex;
    }

    public void setShortestPath(int[] distances,  Set<Integer> visited, List<List<String>> paths, boolean longest) {

        int smallest = get_Smallest_Distanced_Non_Visited_Index(distances, visited);
        if (smallest == -1){
            return;
        }

        for (int i = 0 ; i < adj.length; i++){
            if (adj[smallest][i] == 1){
                int originalDistance = distances[i];
                int newDistance = distances[smallest] + weights[smallest][i];
                if ((longest && newDistance > originalDistance) || (!longest && newDistance < originalDistance)){
                    distances[i] = newDistance;
                    paths.get(i).addAll(paths.get(smallest));
                    paths.get(i).add(nodes.get(i).name);
                }
            }
        }

        visited.add(smallest);
        setShortestPath(distances, visited, paths, longest);
        return;
    }
}
