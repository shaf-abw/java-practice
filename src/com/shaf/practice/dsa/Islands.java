package com.shaf.practice.dsa;/*
* Explanation
numIslands Method:

Initializes the island count.
Traverses the grid and whenever a land cell is encountered, increments the island count and explores the island using DFS.
Returns the island count.
dfs Method:

Performs Depth-First Search to explore the island.
Marks the current cell as visited (by changing '1' to '0').
Explores all adjacent land cells recursively in all 8 directions: up, down, left, right, and diagonals.
Main Method:

Tests the solution with sample inputs and prints the output.
This program efficiently finds the number of islands in the grid using Depth-First Search algorithm.
*
* */

public class Islands {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        // Traverse the grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    count++; // Increment the island count
                    dfs(grid, i, j); // Explore the island using DFS
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Base cases: check for out of bounds and water cells
        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] == '0') {
            return;
        }

        // Mark the current cell as visited
        grid[i][j] = '0';

        // Explore adjacent land cells recursively
        dfs(grid, i + 1, j); // Down
        dfs(grid, i - 1, j); // Up
        dfs(grid, i, j + 1); // Right
        dfs(grid, i, j - 1); // Left
        dfs(grid, i + 1, j + 1); // Diagonal down-right
        dfs(grid, i - 1, j - 1); // Diagonal up-left
        dfs(grid, i + 1, j - 1); // Diagonal down-left
        dfs(grid, i - 1, j + 1); // Diagonal up-right
    }

    public static void main(String[] args) {
        Islands solution = new Islands();

        // Test cases
        char[][] grid1 = {
                {'0', '1'},
                {'1', '0'},
                {'1', '1'},
                {'1', '0'}
        };
        System.out.println("Output1: " + solution.numIslands(grid1)); // Expected output: 1

        char[][] grid2 = {
                {'0', '1', '1', '1', '0', '0', '0'},
                {'0', '0', '1', '1', '0', '1', '0'}
        };
        System.out.println("Output2: " + solution.numIslands(grid2)); // Expected output: 2
    }

}
