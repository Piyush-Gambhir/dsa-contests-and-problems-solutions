/*
Problem Link: https://leetcode.com/problems/longest-palindromic-substring/
*/

public class Solution {
    public static String longestPalinSubstring(String str) {
        // Write your code here.
        int n = str.length();
        boolean[][] dp = new boolean[n][n];
        int maxLen = 0;
        int start = 0;
        for (int g = 0; g < n; g++) {
            for (int i = 0, j = g; j < n; i++, j++) {
                if (g == 0) {
                    dp[i][j] = true;
                } else if (g == 1) {
                    dp[i][j] = str.charAt(i) == str.charAt(j);
                } else {
                    dp[i][j] = str.charAt(i) == str.charAt(j) && dp[i + 1][j - 1];
                }

                if (dp[i][j] && g + 1 > maxLen) {
                    maxLen = g + 1;
                    start = i;
                }
            }
        }

        return str.substring(start, start + maxLen);
    }
}
