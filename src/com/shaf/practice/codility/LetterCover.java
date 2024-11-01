package com.shaf.practice.codility;

import java.util.*;

/*
Pi Code Challenge
* We are given two strings P and Q, each consisting of N lowercase English letters. For each position in the strings,
* we have to choose one letter from either P or Q, in order to construct a new string S, such that the number of distinct
* letters in S is minimal. Our task is to find the number of distinct letters in the resulting string S.

For example, if P = "ca" and Q = "ab", S can be equal to: "ca", "cb", "aa" or "ab". String "aa" has only one distinct
* letter ('a'), so the answer is 1 (which is minimal among those strings).

Write a function:

class Solution { public int solution(String P, String Q); }

that, given two strings P and Q, both of length N, returns the minimum number of distinct letters of a string S,
* that can be constructed from P and Q as described above.

Examples:

1. Given P = "abc", Q = "bcd", your function should return 2. All possible strings S that can be constructed are:
* "abc", "abd", "acc", "acd", "bbc", "bbd", "bcc", "bcd". The minimum number of distinct letters is 2,
* which be obtained by constructing the following strings: "acc", "bbc", "bbd", "bcc".

2. Given P = "axxz", Q = "yzwy", your function should return 2. String S must consist of at least two distinct
* letters in this case. We can construct S = "yxxy", where the number of distinct letters is equal to 2,
* and this is the only optimal solution.

3. Given P = "bacad", Q = "abada", your function should return 1. We can choose the letter 'a' in each position,
* so S can be equal to "aaaaa".

4. Given P = "amz", Q = "amz", your function should return 3. The input strings are identical,
* so the only possible S that can be constructed is "amz", and its number of distinct letters is 3.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..200,000];
strings P and Q are both of length N;
strings P and Q are made only of lowercase letters (a−z);
strings P and Q contain a total of at most 20 distinct letters.

Test result : https://app.codility.com/cert/view/certAPHQZX9HWFUKYGZH-6DK/details/
* */
public class LetterCover {

    private void generateStrings(String P, String Q, int index, StringBuilder current, List<String> result) {
        // Base case: if we've processed all positions, add the current string to the result
        if (index == P.length()) {
            result.add(current.toString());
            return;
        }

        // Choice 1: Choose the character from string P at this position
        current.append(P.charAt(index));
        generateStrings(P, Q, index + 1, current, result);
        current.deleteCharAt(current.length() - 1); // Backtrack

        // Choice 2: Choose the character from string Q at this position
        current.append(Q.charAt(index));
        generateStrings(P, Q, index + 1, current, result);
        current.deleteCharAt(current.length() - 1); // Backtrack
    }

    private int countDistinctLetters(String S) {
        Set<Character> distinctLetters = new HashSet<>();

        // Iterate through each character in the string
        for (char c : S.toCharArray()) {
            distinctLetters.add(c);  // Add the character to the set
        }

        // Return the number of distinct characters
        return distinctLetters.size();
    }

    private void generateAndCount(String P, String Q, int index, StringBuilder current, Set<Character> currentSet, int[] minDistinct) {
        // Base case: if we've processed all positions, check distinct count
        if (index == P.length()) {
            minDistinct[0] = Math.min(minDistinct[0], currentSet.size());
            return;
        }

        // Choice 1: Choose the character from string P at this position
        current.append(P.charAt(index));
        boolean isNewCharP = currentSet.add(P.charAt(index));
        generateAndCount(P, Q, index + 1, current, currentSet, minDistinct);
        current.deleteCharAt(current.length() - 1);
        if (isNewCharP) currentSet.remove(P.charAt(index)); // Backtrack

        // Choice 2: Choose the character from string Q at this position
        current.append(Q.charAt(index));
        boolean isNewCharQ = currentSet.add(Q.charAt(index));
        generateAndCount(P, Q, index + 1, current, currentSet, minDistinct);
        current.deleteCharAt(current.length() - 1);
        if (isNewCharQ) currentSet.remove(Q.charAt(index)); // Backtrack
    }

    public int solution(String P, String Q) {
        // Implement your solution here
        int distinctCount = P.length();;

//        List<String> result = new ArrayList<>();
//        generateStrings(P, Q, 0, new StringBuilder(), result);
//
//        for (String s : result) {
//            int i = countDistinctLetters(s);
//            if (distinctCount > i) {
//                distinctCount = i;
//            }
//        }

        // Performance Improved version
        int[] minDistinct = new int[]{P.length()};
        generateAndCount(P, Q, 0, new StringBuilder(), new HashSet<>(), minDistinct);
        distinctCount = minDistinct[0];

        return distinctCount;
    }

}
