package com.shaf.practice.java8;

import java.util.Arrays;
import java.util.List;

interface Parser {
    String parse(String str);
}

class StringParser {
    public static String toUppercase(String s) {
        return s.toUpperCase();
    }
}

class MyPrinter {
    public void print(String str, Parser p) {
        str = p.parse(str);
        System.out.println(str);
    }
}

/*
* Passing a method as a reference (Object)
* Calling by Method
* */
public class MethodReference {

    public static void main(String args[]) {

        List<Integer> values = Arrays.asList(2,4,5,6,7,8);
        values.forEach(System.out::println);

        String str = "Shafeeque";
        MyPrinter mp = new MyPrinter();
        mp.print(str, StringParser::toUppercase);

    }
}
