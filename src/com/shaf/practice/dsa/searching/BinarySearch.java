package com.shaf.practice.dsa.searching;

public class BinarySearch {

    public static int binarySearch(int[] nums, int target, int left, int right) {

        if (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                return binarySearch(nums, target, mid + 1, right);
            } else {
                return binarySearch(nums, target, left, mid - 1);
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] nums = {3,4,5,7,8,9,15,21}; // Sorted Array

        int target = 8;

        int index = binarySearch(nums, target, 0, nums.length -1);

        if (index != -1) {
            System.out.println("The index of target value is " + index);
        } else {
            System.out.println("The target is not found");
        }

    }
}
