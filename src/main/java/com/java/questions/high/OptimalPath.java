package com.java.questions.high;

/*

DHRUV



public static Integer optimalPath(Integer[][] grid) {
   if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
   }
   int startRow = grid.length - 1;
   int startCol = 0;

   int finalRow = 0;
   int finalCol = grid[0].length - 1;
   int[][] sumGrid = new int[grid.length][grid[0].length];
   sumGrid[startRow][startCol] = grid[startRow][startCol];
   Point src = new Point(startRow, startCol);
   Queue<Point> queue = new LinkedList<>();
   queue.add(src);
   while (!queue.isEmpty()) {
      Point currPoint = queue.poll();
      Point up = new Point(currPoint.x - 1, currPoint.y);
      if (currPoint.x >=finalRow && currPoint.y <= finalCol) {
         sumGrid[up.x][up.y] = Math.max(sumGrid[up.x][up.y], grid[up.x][up.y] + sumGrid[currPoint.x][currPoint.y]);
         queue.add(up);
      }
      Point right = new Point(currPoint.x, currPoint.y + 1);
      if (currPoint.x >=finalRow && currPoint.y <= finalCol) {
         sumGrid[right.x][right.y] = Math.max(sumGrid[right.x][right.y], grid[right.x][right.y] + sumGrid[currPoint.x][currPoint.y]);
         queue.add(right);
      }
   }
   System.out.println(sumGrid[finalRow][finalCol]);
   return sumGrid[finalRow][finalCol];
}
private static class Point {
    int x;
    int y;
    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
}


 */



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
