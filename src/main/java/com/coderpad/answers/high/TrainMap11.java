package com.coderpad.answers.high;

/**
 * Implement def shortestPath(self, fromStationName, toStationName)
 * method to find shortest path between 2 stations
 */

/*
 *      Visual representation of the Train map used
 *
 *      [A]King's Cross St Pancras --- [D]Angel ---- [G]Old Street
 *      |                   \                            |
 *      |                    \                            |
 *      |                     \                            |
 *      [B]Russell Square         [E]Farringdon --- [H]Barbican --- [J]Moorgate
 *      |                                                  /
 *      |                                                 /
 *      |                                                /
 *      [C]Holborn --- [F]Chancery Lane --- [I]St Paul's --- [K]Bank
 *
 *
 *      12:50
 *
 *
 *      Solution:
 *
 *      1.. refactor the current problem, remove station class, create simple Graph with matric as adj[][], weight[][], maps as indexToName, nameToIndex maps,
 *
 *      2.. create looping data structures for sortest path loop distances[] , Set<Integers> consumed indexes, List<List<String>> paths
 *              initialize distances[] to 1 for existing adj[][],distances[start] = 0,  add start index to consumed,  paths to empty lists
 *
 *      3.. create function int getShortestDistanceNonConsumed(int[] distances, List<Integer> consumed), which returns the shortest distance , whose index has not been consumed yet
 *
 *      4.. create loop function : void shortestPathLoop(List<List<String>> paths, int[] distances, List<Integer> consumed)
 *          above function will get the getShortestDistanceNonConsumed as current index, consume it, find all its edges and reset the distances and paths structures.
 *
 *
 */

import java.util.*;

public class TrainMap11 {
    /**
     * class Station
     * <p>
     * Respresents Station in the rail network. Each station is identified by
     * unique name. Station is connected with other stations - this information
     * is stored in the 'neighbours' field. Two station objects with the same name are
     * equal therefore they are considered to be same station.
     */

    /**
     * class TrainMap
     * <p>
     * Respresents whole rail network - consists of number of the Station objects.
     * Stations in the map are bi-directionally connected. Distance between any 2 stations
     * is of same constant distance unit. This implies that shortest distance between any
     * 2 stations depends only on number of stations in between
     */
    private static class TrainMap {

        int[][] adj;
        int totalNodes = 0;
        int[][] weight;
        int index = 0;

        Map<String, Integer> nameToIndexMap = new HashMap<>();
        Map<Integer, String> indexToNameMap = new HashMap<>();

        public TrainMap(int totalNodes) {

            this.totalNodes = totalNodes;
            adj = new int[totalNodes][totalNodes];
            weight = new int[totalNodes][totalNodes];

        }

        public TrainMap addStation(String name) {

            nameToIndexMap.put(name, index);
            indexToNameMap.put(index, name);
            index++;

            return this;
        }

        public TrainMap connectStations(String fromStation, String toStation) {

            adj[nameToIndexMap.get(fromStation)][nameToIndexMap.get(toStation)] = 1;
            weight[nameToIndexMap.get(fromStation)][nameToIndexMap.get(toStation)] = 1;

            return this;
        }

        public List<String> shortestPath(String from, String to) {

            /*
             * TODO Implement
             */

            int[] distances = new int[adj.length];
            List<Integer> consumed  = new ArrayList<>();

            List<List<String>> paths = new ArrayList<>();
            for (int i = 0 ; i < totalNodes; i++){

                paths.add(new ArrayList<>());
            }

            Integer start = nameToIndexMap.get(from);

            for (int i = 0 ; i < adj.length; i++){

                if (adj[start][i] == 1){
                    distances[i] = 1;
                    paths.get(i).add(indexToNameMap.get(i));
                }else {
                    distances[i] = Integer.MAX_VALUE;
                }

            }

            distances[nameToIndexMap.get(from)] = 0;
            consumed.add(nameToIndexMap.get(from));

            shortestPathLoop(paths, distances, consumed);
            return paths.get(nameToIndexMap.get(to));
        }

        public int getShortestDistanceNonConsumed(int[] distances, List<Integer> consumed){

            int minDistance = Integer.MAX_VALUE;
            int index = -1;
            for (int i = 0; i < distances.length; i++){

                if (distances[i] <= minDistance && !consumed.contains(i)){
                    minDistance = distances[i];
                    index = i;
                }

            }
            return index;
        }

        public void shortestPathLoop(List<List<String>> paths, int[] distances, List<Integer> consumed){

            // get the shortest distances index , which has not been consumed yet.
            int currentIndex = getShortestDistanceNonConsumed(distances, consumed);
            consumed.add(currentIndex);
            if (currentIndex == -1){
                return;
            }
            for (int i = 0 ; i < adj.length; i++){

                if (adj[currentIndex][i] == 1){

                    if (distances[currentIndex] + 1 < distances[i]){

                        distances[i] = distances[currentIndex] + 1;

                        paths.set(i, new ArrayList<>());
                        paths.get(i).addAll(paths.get(currentIndex));
                        paths.get(i).add(indexToNameMap.get(i));

                    }

                }else {

                }

            }

            shortestPathLoop(paths, distances, consumed);

        }

        public static String convertPathToStringRepresentation(List<String> path) {

            if (path.isEmpty()) {
                return "";
            }

            return path.stream().reduce((s1, s2) -> s1 + "->" + s2).get();
        }
    }


    public static boolean doTestsPass() {

        // todo: implement more tests, please
        // feel free to make testing more elegant
        TrainMap trainMap = new TrainMap(11);

        trainMap.addStation("A").addStation("B").addStation("C").addStation("D")
                .addStation("E").addStation("F").addStation("G").addStation("H")
                .addStation("I").addStation("J").addStation("K");

        trainMap.connectStations("A", "B")
                .connectStations("A", "D")
                .connectStations("A", "E")

                .connectStations("D", "G")
                .connectStations("E", "H")

                .connectStations("H", "I")
                .connectStations("H", "J")

                .connectStations("I", "K")

                .connectStations("B", "C")
                .connectStations("C", "F")
                .connectStations("F", "I")
                .connectStations("A", "D")
        ;

        String solution = "E->H->I";

        return solution.equals(TrainMap.convertPathToStringRepresentation(trainMap.shortestPath("A", "I")));
    }

    public static void main(String[] args) {
        if (doTestsPass()) {
            System.out.println("All tests pass");
        } else {
            System.out.println("Tests fail.");
        }
    }
}