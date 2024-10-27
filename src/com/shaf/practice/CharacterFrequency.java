package com.shaf.practice;

import java.util.ArrayList;
import java.util.List;

/*
* Long Encoded String
Consider a string that consists of lowercase English letters (i.e., [a-z)) only. The following rules are used to encode all of its characters into the string 5.
a is encoded as 1, b is encoded as 2, c is encoded as 3, ..., and / is encoded as 9.
jis encoded as 10#, k is encoded as 11#, / is encoded as 12#,..., and z is encoded as 26#.
If any character occurs two or more consecutively, its count immediately follows the encoded character in parentheses, e.g. 'aa' is encoded as '1(2).
Examples
String "abzx"is encoded as 5 = "1226#24#".
string "aabcce" is encoded as s = "1(2)23(3)".
String "bajj" is encoded as s = "2110#(2)".
String "wwxyzwww" is encoded as s = "23#(2)24#25#26#23#(3)".
Given an encoded string s, determine the character counts for each letter of the original, decoded string.
Return array of 26 integers where index 0 contains the number of 'a' characters, index 1 contains the number of 'b' characters, and so on.
Function Description
Complete the frequency function in the editor below.
frequency has the following parameter:
string si an encoded string
Return
int|26]: the character frequencies as described
Constraints
String s consists of decimal integers from 0 to 9, #s, and ()s only.
1 slength of s ≤ 105
It is guaranteed that string s is a valid encoded string.
2 ≤ c≤ 101, where cis a parenthetical count of consecutive occurrences of an encoded character.
*
* */
public class CharacterFrequency {

    public static List<Integer> frequency(String s) {
        int[] freq = new int[26];  // Array to store frequencies for 'a' to 'z'
        int i = 0;
        int n = s.length();

        while (i < n) {
            int charIndex;
            int count = 1;  // Default count is 1

            // Check if the current character is followed by a '#', indicating 10# to 26# (j to z)
            if (i + 2 < n && s.charAt(i + 2) == '#') {
                charIndex = Integer.parseInt(s.substring(i, i + 2)) - 1;  // Convert '10#' to '26#' to index 9 to 25
                i += 3;  // Move past the '##'
            } else {
                charIndex = s.charAt(i) - '1';  // Convert '1' to '9' to index 0 to 8 (a to i)
                i++;
            }

            // Check if the next part is a repetition count (look for '(')
            if (i < n && s.charAt(i) == '(') {
                int j = i + 1;
                while (j < n && s.charAt(j) != ')') {
                    j++;
                }
                count = Integer.parseInt(s.substring(i + 1, j));  // Extract the number inside the parentheses
                i = j + 1;  // Move past the ')'
            }

            // Update the frequency for the decoded character
            freq[charIndex] += count;
        }

        // Convert the frequency array to a List<Integer>
        List<Integer> frequencyList = new ArrayList<>();
        for (int f : freq) {
            frequencyList.add(f);
        }

        return frequencyList;
    }

    public static void main(String[] args) {
        // Test case
        String s1 = "1226#24#";
        String s2 = "1(2)23(3)";
        String s3 = "2110#(2)";
        String s4 = "23#(2)24#25#26#23#(3)";

        List<Integer> result = frequency(s4);

        // Print the frequencies of characters from 'a' to 'z'
        for (int i = 0; i < result.size(); i++) {
            System.out.println((char) ('a' + i) + ": " + result.get(i));
        }
    }
}
