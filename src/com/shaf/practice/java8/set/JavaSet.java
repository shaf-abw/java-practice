package com.shaf.practice.java8.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
* Set extends Collection
* set basic have a collection on Unique and it doesn't allow duplicate value.
* HashSet - Not sorted
* TreeSet - extends AbstractSet and it should be sorted as Asc
*
* */
public class JavaSet {

    public static void main (String[] args) {

        Set<Integer> nums = new HashSet<>();

        nums.add(24);
        nums.add(15);
        nums.add(22);

        System.out.println(nums);

        Iterator<Integer> values = nums.iterator();

        while (values.hasNext())
            System.out.println(values.next());
    }
}
