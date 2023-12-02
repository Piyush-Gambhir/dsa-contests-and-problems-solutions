/*
Problem Link: https://practice.geeksforgeeks.org/problems/77e1c3e12cd148f835d53eb168d4472b2ff539fa/1
*/

//User function Template for Java

class Solution {
    public int[] findMaxRow(int mat[][], int N) {
        // code here
        int max = 0;
        int maxRow = 0;

        for (int i = 0; i < N; i++) {
            int count = 0;
            for (int j = N - 1; j >= 0; j--) {
                if (mat[i][j] != 0) {
                    count++;
                }
            }
            if (count > max) {
                max = count;
                maxRow = i;
            }
        }

        int[] ans = new int[2];
        ans[0] = maxRow;
        ans[1] = max;
        return ans;
    }
}