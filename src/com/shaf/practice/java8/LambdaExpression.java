package com.shaf.practice.java8;

interface A {
    void show(String name);
}

/*
* In Java implement the interface without creating implement class,
* Lambda which is used to reduce the line of boilerplate code to simple.
* */
public class LambdaExpression {

    public static void main(String args[]) {

        // Normal way of implementing Interface
        A obj = new A() {
            public void show(String name) {
                System.out.println("Hello "+name);
            }
        };

        // Implementing interface with Lambda expression
        obj = (String name) -> System.out.println("Hello "+name);

        obj.show("Shafeeque");
    }
}
