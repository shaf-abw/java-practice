package com.shaf.practice.dsa.linkedList;

public class Runner {

    public static void main(String args[]) {

        LinkedList list = new LinkedList();
        list.insert(5);
        list.insert(10);
        list.insert(27);
        list.insertAtStart(13);
        list.insertAt(0,45);
        list.deleteAt(3);

        list.show();
    }
}
