package com.shaf.practice.dsa;

import java.util.ArrayList;
import java.util.List;

/*
* Explanation
minDistance Method:

Calculates the minimum edit distance between two strings using dynamic programming.
Initializes a 2D array dp to store the minimum edit distances.
Iterates through the characters of both words and fills the dp array with the minimum edit distances.
Returns dp[m][n], where m and n are the lengths of word1 and word2, respectively.
transformSteps Method:

Calculates the transformation steps needed to convert word1 into word2.
Utilizes the same dynamic programming approach as the minDistance method to populate the dp array.
Backtracks through the dp array to find the transformation steps.
Returns a list of transformation steps.
Main Method:

Tests the solution with sample inputs.
Prints the minimum iterations required and the transformation steps.
This program efficiently finds the minimum iterations required to transform word1 into word2 and prints the transformation steps accordingly.
* */

public class TransformWord {

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        // Create a 2D array to store the minimum edit distances
        int[][] dp = new int[m + 1][n + 1];

        // Initialize the first row and first column
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        // Calculate the minimum edit distances
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }

        // Return the minimum edit distance
        return dp[m][n];
    }

    public List<String> transformSteps(String word1, String word2) {
        List<String> steps = new ArrayList<>();
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }

        // Backtrack to find the transformation steps
        int i = m, j = n;
        while (i > 0 || j > 0) {
            if (i > 0 && dp[i][j] == dp[i - 1][j] + 1) {
                steps.add("Delete '" + word1.charAt(i - 1) + "'");
                i--;
            } else if (j > 0 && dp[i][j] == dp[i][j - 1] + 1) {
                steps.add("Insert '" + word2.charAt(j - 1) + "'");
                j--;
            } else if (i > 0 && j > 0 && dp[i][j] == dp[i - 1][j - 1] + 1) {
                steps.add("Replace '" + word1.charAt(i - 1) + "' with '" + word2.charAt(j - 1) + "'");
                i--;
                j--;
            } else {
                i--;
                j--;
            }
        }

        return steps;
    }

    public static void main(String[] args) {
        TransformWord solution = new TransformWord();

        // Test cases
        String word1 = "inform";
        String word2 = "form";
        int minDistance = solution.minDistance(word1, word2);
        List<String> steps = solution.transformSteps(word1, word2);

        System.out.println("Minimum iterations required: " + minDistance);
        System.out.println("Transformation steps:");
        for (int i = steps.size() - 1; i >= 0; i--) {
            System.out.println(steps.get(i));
        }
    }

}
