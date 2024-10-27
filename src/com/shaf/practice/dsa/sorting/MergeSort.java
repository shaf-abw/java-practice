package com.shaf.practice.dsa.sorting;

public class MergeSort {

    public static void mergeSort(int[] nums, int left, int right) {

        if (left < right) {

            int mid = (left+right)/2;

            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);

            merge(nums, left, mid, right);
        }
    }

    private static void merge(int[] nums, int left, int mid, int right) {

//        // Initialize two pointers for nums1 and nums2 respectively
//        int i = m - 1; // Pointer for nums1
//        int j = n - 1; // Pointer for nums2
//        int k = m + n - 1; // Pointer for the last position in nums1
//
//        // Merge the arrays starting from the end
//        while (i >= 0 && j >= 0) {
//            if (nums1[i] > nums2[j]) {
//                nums1[k--] = nums1[i--];
//            } else {
//                nums1[k--] = nums2[j--];
//            }
//        }
//
//        // If there are remaining elements in nums2, copy them
//        while (j >= 0) {
//            nums1[k--] = nums2[j--];
//        }
        
    }

    public static void main(String[] args) {

        int[] nums = {7,9,21,3,8,4,5,15}; // Random Array

        System.out.println("Before Quick Sorting");
        for (int i : nums) {
            System.out.print(i + " ");
        }

        mergeSort(nums, 0, nums.length-1);

        System.out.println();
        System.out.println("After Quick Sorting");
        for (int i : nums) {
            System.out.print(i + " ");
        }

    }

}
