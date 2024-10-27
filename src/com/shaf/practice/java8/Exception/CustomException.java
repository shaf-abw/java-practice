package com.shaf.practice.java8.Exception;

public class CustomException extends Exception {

    CustomException(String message) {
        super(message);
    }

    public static void main(String[] args){

        int i = 20;
        int j = 0;

        try {
            j = 18 / i;

            if (j == 0) {
                throw new CustomException("Don't want to print zero");
            }

        } catch (CustomException e) {
            System.out.println("Something went wrong -> "+e.getMessage());
        }


    }
}
