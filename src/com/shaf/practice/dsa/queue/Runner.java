package com.shaf.practice.dsa.queue;

public class Runner {

    public static void main(String str[]) {
        Queue nums = new Queue();

        nums.enQueue(3);
        nums.enQueue(5);
        nums.enQueue(7);
        nums.deQueue();

        nums.show();
    }
}
