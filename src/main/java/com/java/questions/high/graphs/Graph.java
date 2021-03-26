package com.java.questions.high.graphs;

public interface Graph {

    public void addEdge(int from, int to);
    public void addEdge(int from, int to, int weight);
    public void BFS(int start);
    public void DFS(int start);
    public void printGraph();
    public void setShortestPath(int start, boolean longest);
}
