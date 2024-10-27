package com.shaf.practice.java8;

interface Phone {
    void call();

    /*
     * Before 8 java interface shouldn't allow to define method
     * But here we can define the method in interface by using default / static
     * */
    default void message(){
        System.out.println("Hello");
    }
}

class AndroidPhone implements Phone {

    @Override
    public void call() {
        System.out.println("Calling...");
    }
}

public class Interface {

    public static void main(String args[]) {
        Phone p = new AndroidPhone();
        p.call();
        p.message();
    }

}
