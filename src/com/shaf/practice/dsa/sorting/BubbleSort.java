package com.shaf.practice.dsa.sorting;

/*
 * Algorithm Procedure
 *
 * BubbleSort (nums[])
 *       for (i=0 to size(nums))
 *           for (j=i to size(nums))
 *               if (nums[j+1] < nums[i]) {
 *                   swap(nums[j+1],nums[i])
 * */
public class BubbleSort {

    public static void bubbleSort(int[] nums) {

        int size = nums.length - 1;
        int temp = 0;
        for (int i=0;i<size;i++) {
            for (int j=i;j<size;j++) {
                if (nums[i] > nums[j+1]){
                    temp = nums[j+1];
                    nums[j+1] = nums[i];
                    nums[i] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {

        int[] nums = {7,9,21,3,8,4,5,15}; // Random Array

        System.out.println("Before Bubble Sorting");
        for (int i : nums) {
            System.out.print(i + " ");
        }

        bubbleSort(nums);

        System.out.println();
        System.out.println("After Bubble Sorting");
        for (int i : nums) {
            System.out.print(i + " ");
        }

    }

}
