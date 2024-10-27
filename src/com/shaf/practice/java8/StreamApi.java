package com.shaf.practice.java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
* Stream - Is lazy and pipelined operations, and it will return as stream
* Once used can't be re-used.
* Intermediate - Filter(), map(), Sorted()
* Terminate - findFirst(), forEach(), count()
*
* Parallel Stream - It will create multiple thread
* */
public class StreamApi {



    public static void main(String args[]) {

        List<Integer> values = new ArrayList<>();

        for (int i=0;i<=100;i++) {
            values.add(i);
        }
        values.forEach(System.out::println);

        // Stream
        values.stream().forEach(System.out::println);

        List<Integer> nums = Arrays.asList(4,5,6,7,8);

        int result = nums.stream()
                .filter(n -> n%2 == 1)
                .sorted()
                .map(n -> n * 2)
                .reduce(0, (c,e) -> c+e);

        System.out.println(result);

//                .forEach(n -> System.out.println(n));

        // Sort
        nums = Arrays.asList(4,5,6,7,8);
        Collections.sort(nums);
    }


}


