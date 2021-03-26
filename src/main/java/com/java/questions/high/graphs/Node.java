package com.java.questions.high.graphs;

import java.util.Objects;

class Node{

    public int value;
    public int weight;
    public Node next;

    public Node() {
    }

    public Node(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "{" +
                "value=" + value +
                ", weight=" + weight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return value == node.value &&
                weight == node.weight;
    }

    @Override
    public int hashCode() {

        return Objects.hash(value, weight);
    }
}

