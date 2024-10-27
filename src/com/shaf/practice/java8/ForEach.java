package com.shaf.practice.java8;

import java.util.Arrays;
import java.util.List;

/*
* Before Java 8 we have external loops which takes more time to run
* In Java 8 we have internal loops.
* */
public class ForEach {

    public static void main(String args[]) {
        List<Integer> values = Arrays.asList(4,5,6,7,8);

        // For Each is the internal part of collection.
        values.forEach(i -> System.out.println(i));
    }
}
