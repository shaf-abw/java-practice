package com.shaf.practice.dsa.linkedList;

public class Node {
    int data;
    Node next;

    public Node(int value, Node next) {
        this.data = value;
        this.next = next;
    }

    public int getValue() {
        return data;
    }

    public void setValue(int value) {
        this.data = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}
