package com.shaf.practice.dsa.queue;

public class Queue {
    int capacity = 5;
    int queue[] = new int[capacity];
    int size;
    int front;
    int rear;

    public void enQueue(int data) {
        if (!isFull()) {
            queue[rear] = data;
            rear = (rear + 1) % capacity;
            size = size + 1;
        } else {
            System.out.println("Queue is full");
        }
    }

    public int deQueue() {
        int data = 0;
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            data = queue[front];
            front = (front + 1) % capacity;
            size = size - 1;
        }
        return data;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public boolean isFull() {
        return getSize() == capacity;
    }

    public void show() {
        System.out.println("Elements :");
        for (int i=0;i<size;i++) {
            System.out.print(queue[(front+i)%capacity]+" ");
        }
        System.out.println();
    }
}
