package com.shaf.practice.java8;

/*
* Func interface should not allow to use multiple abstract method
* */
@FunctionalInterface
interface FI {
    void show(String name);
}

public class FunctionInterface {

    public static void main(String args[]) {
        FI obj = name -> System.out.println("Hello "+name);

        obj.show("Shafeeque");
    }
}
