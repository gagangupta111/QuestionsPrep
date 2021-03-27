package com.coderpad.answers.low;

public class DequeExample {

    public static void main(String[] args){




        DequeInterface dequeInterface = new DequeClass();

        System.out.println("============");
        System.out.println("Front: " + dequeInterface.getFront());
        System.out.println("Rear: " + dequeInterface.getRear());
        System.out.println("Size: " + dequeInterface.size());
        System.out.println("Is Empty: " + dequeInterface.isEmpty());

        dequeInterface.deleteFront();
        System.out.println("============");
        System.out.println("Front: " + dequeInterface.getFront());
        System.out.println("Rear: " + dequeInterface.getRear());
        System.out.println("Size: " + dequeInterface.size());
        System.out.println("Is Empty: " + dequeInterface.isEmpty());


        dequeInterface.deleteRear();
        System.out.println("============");
        System.out.println("Front: " + dequeInterface.getFront());
        System.out.println("Rear: " + dequeInterface.getRear());
        System.out.println("Size: " + dequeInterface.size());
        System.out.println("Is Empty: " + dequeInterface.isEmpty());


        dequeInterface.insertFront(100);
        System.out.println("============");
        System.out.println("Front: " + dequeInterface.getFront());
        System.out.println("Rear: " + dequeInterface.getRear());
        System.out.println("Size: " + dequeInterface.size());
        System.out.println("Is Empty: " + dequeInterface.isEmpty());


        dequeInterface.insertRear(200);
        System.out.println("============");
        System.out.println("Front: " + dequeInterface.getFront());
        System.out.println("Rear: " + dequeInterface.getRear());
        System.out.println("Size: " + dequeInterface.size());
        System.out.println("Is Empty: " + dequeInterface.isEmpty());



        dequeInterface.deleteFront();
        System.out.println("============");
        System.out.println("Front: " + dequeInterface.getFront());
        System.out.println("Rear: " + dequeInterface.getRear());
        System.out.println("Size: " + dequeInterface.size());
        System.out.println("Is Empty: " + dequeInterface.isEmpty());


        dequeInterface.deleteRear();
        System.out.println("============");
        System.out.println("Front: " + dequeInterface.getFront());
        System.out.println("Rear: " + dequeInterface.getRear());
        System.out.println("Size: " + dequeInterface.size());
        System.out.println("Is Empty: " + dequeInterface.isEmpty());


    }


}



interface DequeInterface{

    public void insertFront(int i);
    public void insertRear(int i);

    public int getRear();
    public int getFront();

    public int deleteFront();
    public int deleteRear();

    public int size();
    public boolean isFull();
    public boolean isEmpty();

}


class Node{

    int value;
    Node next ;
    Node previous;

}
class DequeClass implements DequeInterface{

    Node front;
    Node rear;

    @Override
    public void insertFront(int i) {

        if (front == null && rear == null){
            front = new Node();
            front.value = i;
            rear = front;
            return;
        }

        Node newFront  = new Node();
        newFront.value = i;

        newFront.previous = front;
        front.next = newFront;

        front = newFront;
        return;

    }

    @Override
    public void insertRear(int i) {

        if (front == null && rear == null){
            rear = new Node();
            rear.value = i;
            front = rear;
            return;
        }

        Node newRear  = new Node();
        newRear.value = i;

        newRear.next = rear;
        rear.previous = newRear;

        rear = newRear;
        return;
    }

    @Override
    public int getRear() {

        if (rear == null){
            return -1;
        }

        return rear.value;
    }

    @Override
    public int getFront() {

        if (front == null) {
            return -1;
        }

        return front.value;

    }

    @Override
    public int deleteFront() {

        if (front == null){
            return -1;
        }

        if (front == rear){

            int temp = front.value;
            front = rear = null;
            return temp;

        }

        int temp = front.value;
        front = front.previous;
        front.next = null;
        return temp;

    }

    @Override
    public int deleteRear() {

        if (rear == null){
            return -1;
        }

        if (front == rear){

            int temp = rear.value;
            front = rear = null;
            return temp;

        }

        int temp = rear.value;
        rear = rear.next;
        rear.previous = null;
        return temp;
    }

    @Override
    public int size() {

        int size = 0;
        Node start = front;
        while (start != null){

            size++;
            start = start.previous;

        }


        return size;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isEmpty() {

        if (front == null){
            return true;
        }
        return false;
    }
}