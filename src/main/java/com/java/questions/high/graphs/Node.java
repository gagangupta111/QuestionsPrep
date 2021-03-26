package com.java.questions.high.graphs;

import java.util.Objects;

public class Node{

    public int value;
    public int weight;
    public Node next;
    public String name;

    public Node() {
    }

    public Node(String name) {
        this.name = name;
    }

    public Node(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", weight=" + weight +
                ", next=" + next +
                ", name='" + name + '\'' +
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

