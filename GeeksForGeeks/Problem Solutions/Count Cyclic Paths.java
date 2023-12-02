/*
Problem Link: https://practice.geeksforgeeks.org/problems/aa0000a5f710ce8d41366b714341eef644ec7b82/1
*/

import java.util.*;

class Solution {
    static final int MOD = 1000000007;

    public static int countPaths(int N) {
        int[][] dp = new int[4][N + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= 3; j++) {
                dp[j][i] = (dp[j][i] + dp[(j + 1) % 4][i - 1]) % MOD;
                dp[j][i] = (dp[j][i] + dp[(j + 2) % 4][i - 1]) % MOD;
                dp[j][i] = (dp[j][i] + dp[(j + 3) % 4][i - 1]) % MOD;
            }
        }
        return dp[0][N];
    }
}