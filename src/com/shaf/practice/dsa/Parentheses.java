package com.shaf.practice.dsa;

import java.util.ArrayList;
import java.util.List;

/*
* Explanation
Main Method:

Calls the generateParentheses method with different values of nn and prints the results.
generateParentheses Method:

Initializes a list to store the results.
Calls the generate helper method to populate the list with valid combinations.
generate Helper Method:

Uses recursion and backtracking to build the strings of balanced parentheses.
Base Case: If the current string length equals 2 \times n2×n, add the current string to the result list.
Recursive Case:
If the number of open parentheses is less than nn, add an open parenthesis and recursively call generate.
If the number of close parentheses is less than the number of open parentheses, add a close parenthesis and recursively call generate.
*
* */

public class Parentheses {

    public List<String> generateParentheses(int n) {
        List<String> result = new ArrayList<>();
        generate(result, "", 0, 0, n);
        return result;
    }

    private void generate(List<String> result, String current, int open, int close, int max) {
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }

        if (open < max) {
            generate(result, current + "{", open + 1, close, max);
        }
        if (close < open) {
            generate(result, current + "}", open, close + 1, max);
        }
    }

    public static void main(String[] args) {
        Parentheses solution = new Parentheses();
        // Test cases
        System.out.println(solution.generateParentheses(1)); // Expected output: [{}]
        System.out.println(solution.generateParentheses(2)); // Expected output: [{}{}, {{}}]
        System.out.println(solution.generateParentheses(3)); // Expected output: [{}{}, {{}}]
    }
}
