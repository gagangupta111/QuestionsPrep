package com.java.questions.medium;

import java.util.*;
import java.util.stream.Collectors;

class Node implements Comparable<Node>{
    public String ip;
    public int value;


    @Override
    public int compareTo(Node o) {
        if (this.value > o.value){
            return 1;
        }else return -1;
    }
}

public class ApacheLog {

    /**
     * Given a log file, return IP address(es) which accesses the site most often.
     */

    public static String findTopIpaddress(String[] lines) {
        // Your code goes here

        Map<String, Integer> stringIntegerMap = new HashMap<>();
        List<Node> nodes = new LinkedList<>();

        for (String s : lines){

            String[] strings = s.split("-");
            if (stringIntegerMap.get(strings[0].trim()) == null){
                stringIntegerMap.put(strings[0].trim(), 1);
            }else {
                stringIntegerMap.put(strings[0].trim(), stringIntegerMap.get(strings[0].trim()) + 1);
            }

            Optional<Node> optionalNode = nodes.stream().filter((node) -> node.ip.equalsIgnoreCase(strings[0].trim())).findAny();
            if (optionalNode.isPresent()){
                optionalNode.get().value = stringIntegerMap.get(strings[0].trim());
            }else {
                Node node = new Node();
                node.ip = strings[0].trim();
                node.value = stringIntegerMap.get(strings[0].trim());
                nodes.add(node);
            }
        }

        Collections.sort(nodes, Collections.reverseOrder());

        return nodes.get(0).ip;
    }


    public static void main(String[] args) {

        String lines[] = new String[] {
                "10.0.0.1 - log entry 1 11",
                "10.0.0.1 - log entry 2 213",
                "10.0.0.3 - log entry 2 213",
                "10.0.0.3 - log entry 2 213",
                "10.0.0.3 - log entry 2 213",
                "10.0.0.3 - log entry 2 213",
                "10.0.0.2 - log entry 133132" };
        String result = findTopIpaddress(lines);

        if (result.equals("10.0.0.3")) {
            System.out.println("Test passed");

        } else {
            System.out.println("Test failed");

        }

    }

}
