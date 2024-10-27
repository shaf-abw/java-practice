package com.shaf.practice.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerInterface {

    public static void main(String args[]) {
        List<Integer> values = Arrays.asList(4,5,6,7,8);

        // Normal way of using consumer interface Impl
        Consumer<Integer> c = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        };
        values.forEach(c);

        // Consumer with Lambda expression
        Consumer<Integer> cl = i -> System.out.println(i);
        values.forEach(cl);
    }
}
