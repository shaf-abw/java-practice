package com.shaf.practice.java8.map;

import java.util.HashMap;
import java.util.Map;

/*
* Map is collection of key and value pair
* It is interface <K,V>
* It allow only unique key
*
* HashMap and HashTable
* HashMap is not thread safe and un-Sync | Fast | allows one null key
* HashTable is sychronized and its not thread safe | slow | does not allow null key
* */
public class JavaMap {

    public static void main (String[] args) {

        Map<String, Integer> students = new HashMap<>();

        students.put("Shafeeque", 20);
        students.put("Ahamed", 55);

        System.out.println(students);
        System.out.println(students.get("Shafeeque"));
        System.out.println(students.keySet());
        System.out.println(students.values());
        students.put("Ahamed", 25);
        System.out.println(students);

        for (String key : students.keySet()) {
            System.out.println(key + ": " + students.get(key));
        }

    }
}
