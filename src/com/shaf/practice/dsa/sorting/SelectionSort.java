package com.shaf.practice.dsa.sorting;

/*
* Algorithm Procedure
*
* selectSort (nums[])
*       for (i=0 to size(nums))
*           minIndex = i
*           for (j=i+1 to size(nums))
*               if (nums[j] < nums[minIndex]) {
*                   minIndex = j
*           swap(nums[i],nums[minIndex])
* */
public class SelectionSort {

    public static void selectionSort(int[] nums) {

        int size = nums.length;
        int temp = 0;
        for (int i=0;i<size;i++) {

            int minIndex = i;

            for (int j=i+1;j<size;j++) {
                if (nums[minIndex] > nums[j]) {
                    minIndex = j;
                }
            }

            temp = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = temp;
        }
    }

    public static void main(String[] args) {

        int[] nums = {7,9,21,3,8,4,5,15}; // Random Array

        System.out.println("Before Selection Sorting");
        for (int i : nums) {
            System.out.print(i + " ");
        }

        selectionSort(nums);

        System.out.println();
        System.out.println("After Selection Sorting");
        for (int i : nums) {
            System.out.print(i + " ");
        }

    }

}
