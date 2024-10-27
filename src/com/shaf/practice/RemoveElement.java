package com.shaf.practice;

public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int k = 0; // Initialize a pointer for the next position to place a non-val element

        // Iterate over each element in the array
        for (int i = 0; i < nums.length; i++) {
            // If the current element is not equal to val, place it at the position k and increment k
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }

        // Return the number of elements not equal to val
        return k;
    }
}
