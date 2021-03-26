package com.java.questions.high;

import com.java.questions.high.graphs.Graph;
import com.java.questions.high.graphs.Graph_Another;
import com.java.questions.high.graphs.Node;

public class OptimalPath {

    public static void main(String[] args){

        Graph graph = new Graph_Another(11);
        ((Graph_Another) graph).nodes.add(new Node("A"));
        ((Graph_Another) graph).nodes.add(new Node("B"));
        ((Graph_Another) graph).nodes.add(new Node("C"));
        ((Graph_Another) graph).nodes.add(new Node("D"));
        ((Graph_Another) graph).nodes.add(new Node("E"));
        ((Graph_Another) graph).nodes.add(new Node("F"));
        ((Graph_Another) graph).nodes.add(new Node("G"));
        ((Graph_Another) graph).nodes.add(new Node("H"));
        ((Graph_Another) graph).nodes.add(new Node("I"));
        ((Graph_Another) graph).nodes.add(new Node("J"));
        ((Graph_Another) graph).nodes.add(new Node("K"));

        ((Graph_Another) graph).nodeIndexMap.put("A", 0);
        ((Graph_Another) graph).nodeIndexMap.put("B", 1);
        ((Graph_Another) graph).nodeIndexMap.put("C", 2);
        ((Graph_Another) graph).nodeIndexMap.put("D", 3);
        ((Graph_Another) graph).nodeIndexMap.put("E", 4);
        ((Graph_Another) graph).nodeIndexMap.put("F", 5);
        ((Graph_Another) graph).nodeIndexMap.put("G", 6);
        ((Graph_Another) graph).nodeIndexMap.put("H", 7);
        ((Graph_Another) graph).nodeIndexMap.put("I", 8);
        ((Graph_Another) graph).nodeIndexMap.put("J", 9);
        ((Graph_Another) graph).nodeIndexMap.put("K", 10);

        System.out.println("Initiated Graph_Using_List!");
        graph.printGraph();

        graph.addEdge(0,1, 1);
        graph.addEdge(1,2, 1);
        graph.addEdge(2,5, 1);
        graph.addEdge(5,8, 1);
        graph.addEdge(8,10, 1);

        graph.addEdge(0,3, 1);
        graph.addEdge(3,6, 1);
        graph.addEdge(6,7, 1);
        graph.addEdge(7,8, 1);
        graph.addEdge(7,9, 1);

        graph.addEdge(0,4, 1);
        graph.addEdge(4,7, 1);

        graph.printGraph();

        graph.setShortestPath(0, false);

    }

}
