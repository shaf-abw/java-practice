package com.shaf.practice.dsa.searching;

public class LinearSearch {

    public static int linearSearch(int[] nums, int target) {

        for (int i=0;i< nums.length;i++) {
            if (nums[i] == target)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] nums = {7,9,21,3,8,4,5,15}; // Random Array

        int target = 8;

        int index = linearSearch(nums, target);

        if (index != -1) {
            System.out.println("The index of target value is " + index);
        } else {
            System.out.println("The target is not found");
        }

    }
}
