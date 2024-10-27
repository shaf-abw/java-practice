package com.shaf.practice.dsa.sorting;

/*
* Algorithm Procedure
*
* InsertionSort (nums[])
*       for (i=1 to size(nums))
*           key = num[i]
*           j = i - 1
*           while (j>=0 && nums[j] > key)
*               nums[j+1] = nums[j]
*               j--
*           nums[j+1] = key
* */
public class InsertionSort {

    private static void insertionSort(int[] nums) {

        for (int i=1;i<nums.length;i++) {
            int key = nums[i];
            int j = i - 1;

            while (j>=0 && nums[j] > key) {
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = key;

        }

    }

    public static void main(String[] args) {

        int[] nums = {7,9,21,3,8,4,5,15}; // Random Array

        System.out.println("Before Insertion Sorting");
        for (int i : nums) {
            System.out.print(i + " ");
        }

        insertionSort(nums);

        System.out.println();
        System.out.println("After Insertion Sorting");
        for (int i : nums) {
            System.out.print(i + " ");
        }

    }

}
