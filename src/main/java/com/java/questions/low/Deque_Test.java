package com.java.questions.low;

public class Deque_Test {

    public static void main(String[] args){

        Deque deque = new DequeClass();
        System.out.println("front: " + deque.getFront());
        System.out.println("rear: " + deque.getRear());

        System.out.println("=====");
        deque.insertFront(100);
        System.out.println("front: " + deque.getFront());
        System.out.println("rear: " + deque.getRear());

        System.out.println("=====");
        deque = new DequeClass();
        deque.insertRear(200);
        System.out.println("front: " + deque.getFront());
        System.out.println("rear: " + deque.getRear());

        System.out.println("=====");
        deque = new DequeClass();
        deque.insertFront(100);
        System.out.println("front: " + deque.getFront());
        System.out.println("rear: " + deque.getRear());

        System.out.println("=====");
        deque.insertRear(200);
        System.out.println("front: " + deque.getFront());
        System.out.println("rear: " + deque.getRear());

        System.out.println("=====");
        deque.insertRear(300);
        System.out.println("front: " + deque.getFront());
        System.out.println("rear: " + deque.getRear());

        System.out.println("=====");
        deque.insertFront(50);
        System.out.println("front: " + deque.getFront());
        System.out.println("rear: " + deque.getRear());

        System.out.println("=====");
        deque.deleteFront();
        System.out.println("front: " + deque.getFront());
        System.out.println("rear: " + deque.getRear());

        System.out.println("=====");
        deque.deleteRear();
        System.out.println("front: " + deque.getFront());
        System.out.println("rear: " + deque.getRear());

        System.out.println("=====");
        deque.deleteFront();
        System.out.println("front: " + deque.getFront());
        System.out.println("rear: " + deque.getRear());

        System.out.println("=====");
        deque.deleteRear();
        System.out.println("front: " + deque.getFront());
        System.out.println("rear: " + deque.getRear());

        System.out.println("=====");
        deque.insertFront(100);
        System.out.println("front: " + deque.getFront());
        System.out.println("rear: " + deque.getRear());

        System.out.println("=====");
        deque.insertRear(200);
        System.out.println("front: " + deque.getFront());
        System.out.println("rear: " + deque.getRear());

        System.out.println("=====");
        deque.insertRear(300);
        System.out.println("front: " + deque.getFront());
        System.out.println("rear: " + deque.getRear());

        System.out.println("=====");
        deque.insertFront(50);
        System.out.println("front: " + deque.getFront());
        System.out.println("rear: " + deque.getRear());


    }

}



interface Deque{

    public void insertFront(int i);
    public void insertRear(int i);

    public int deleteFront();
    public int deleteRear();

    public int getFront();
    public int getRear();

    public boolean isEmpty();
    public int size();
    public void erase();

}

class Node{

    private static int count = 1;
    public int id;
    public Node next;
    public Node previous;
    public int value;

    public Node() {
        id = count++;
    }
}

class DequeClass implements Deque{

    public Node front;
    public Node rear;

    @Override
    public void insertFront(int i) {

        if (front == null){
            Node newFront = new Node();
            newFront.value = i;

            front = newFront;
            rear = newFront;

            return;
        }else {
            Node newFront = new Node();
            newFront.value = i;

            front.next = newFront;
            newFront.previous = front;

            front = newFront;

            return;
        }


    }

    @Override
    public void insertRear(int i) {

        if (rear == null){
            Node newRear = new Node();
            newRear.value = i;

            front = newRear;
            rear = newRear;

            return;
        }else {
            Node newRear = new Node();
            newRear.value = i;

            rear.previous = newRear;
            newRear.next = rear;

            rear = newRear;
            return;
        }

    }

    @Override
    public int deleteFront() {
        if (front == null){
            return -1;
        }

        if (front == rear){
            int value = front.value;
            front = rear = null;
            return value;
        }

        Node tempFront = front;
        front = tempFront.previous;
        front.next = null;
        return tempFront.value;
    }

    @Override
    public int deleteRear() {

        if (rear == null){
            return -1;
        }

        if (front == rear){
            int value = rear.value;
            front = rear = null;
            return value;
        }

        Node tempRear = rear;
        rear = tempRear.next;
        rear.previous = null;
        return tempRear.value;

    }

    @Override
    public int getFront() {
        if (front == null){
            return -1;
        }
        return front.value;
    }

    @Override
    public int getRear() {
        if (rear == null){
            return -1;
        }
        return rear.value;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void erase() {

    }
}