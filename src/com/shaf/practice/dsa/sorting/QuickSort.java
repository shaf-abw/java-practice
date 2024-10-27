package com.shaf.practice.dsa.sorting;

/*
* Algorithm Procedure
*
* QuickSort (nums[], low, high)
*       if (low < high)
*           pi = partition(nums[], low, high)
*           QuickSort(nums[], low, pi-1)
*           QuickSort(nums[], pi+1, high)
*
* Partition (nums[], low, high)
*       pivot = nums[high]
*       i = low - 1
*       temp = 0
*
*       for (j(low) to < high) {
*           if (nums[j] < pivot)
*               i++
*               swap (nums[i], nums[j])
*       }
*       swap(nums[i+1],nums[high])
*       return i+1
* */
public class QuickSort {

    public static void quickSort(int[] nums, int low, int high) {

        if (low < high) {

            int pi = partition(nums, low, high);

            quickSort(nums, low, pi - 1);
            quickSort(nums, pi + 1, high);
        }

    }

    private static int partition(int[] nums, int low, int high) {

        int pivot = nums[high];
        int i = low - 1;
        int temp = 0;

        for (int j=low;j<high;j++) {
            if (nums[j] < pivot) {
                i++;
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        temp = nums[i+1];
        nums[i+1] = nums[high];
        nums[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {

        int[] nums = {7,9,21,3,8,4,5,15}; // Random Array

        System.out.println("Before Quick Sorting");
        for (int i : nums) {
            System.out.print(i + " ");
        }

        quickSort(nums, 0, nums.length-1);

        System.out.println();
        System.out.println("After Quick Sorting");
        for (int i : nums) {
            System.out.print(i + " ");
        }

    }

}
