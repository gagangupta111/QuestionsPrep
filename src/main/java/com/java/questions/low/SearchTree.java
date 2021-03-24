package com.java.questions.low;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SearchTree {

    static class BST  {

        private Node root;

        public BST() {
            this.root = new Node();
        }

        public void put(int value) {
            if (root == null){
                root = new Node();
                root.val = value;
                return;
            }
            if (root.val == null){
                root.val = value;
                return;
            }
            put(value, root);

            // your code
        }

        public Node put(int value, Node node) {

            Node newNode = null;
            if (node == null){
                return new Node(value);
            }

            if (value <= node.val){
                newNode = put(value, node.left);
                if (newNode != null) {
                    node.left = newNode;
                }
            }else if (value > node.val){
                newNode = put(value, node.right);
                if (newNode != null) {
                    node.right = newNode;
                }
            }

            return null;

        }



        public boolean contains(int value) {
            // your code
            return contains(root, value);
        }

        public boolean contains(Node node, int value) {

            if (node == null){
                return false;
            }
            if (node.val == value){
                return true;
            }
            if (value < node.val){
                return contains(node.left, value);
            }
            if (value > node.val){
                return contains(node.right, value);
            }
            return false;
        }

        public List<Integer> inOrderTraversal() {
            final ArrayList<Integer> acc = new ArrayList<>();
            inOrderTraversal(root, acc);
            return acc;
        }

        private void inOrderTraversal(Node node, List<Integer> acc) {
            if (node == null) {
                return;
            }
            inOrderTraversal(node.left, acc);
            acc.add(node.val);
            inOrderTraversal(node.right, acc);

        }

        private static class Node {
            Integer val;
            Node left;
            Node right;

            public Node() {
            }

            public Node(Integer val) {
                this.val = val;
            }
        }
    }


    public static void main(String[] args) {

        final BST searchTree = new BST();

        searchTree.put(3);
        searchTree.put(1);
        searchTree.put(2);
        searchTree.put(5);

        if(Arrays.asList(1,2,3,5).equals(searchTree.inOrderTraversal())
                && !searchTree.contains(0)
                && searchTree.contains(1)
                && searchTree.contains(2)
                && searchTree.contains(3)
                && !searchTree.contains(4)
                && searchTree.contains(5)
                && !searchTree.contains(6)){
            System.out.println("Pass");
        }else {
            System.out.println("Fail");
        }

    }

}
