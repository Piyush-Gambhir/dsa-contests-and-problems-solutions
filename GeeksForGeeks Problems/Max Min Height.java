/*
Problem Link: https://practice.geeksforgeeks.org/problems/899540d741547e2d75d1c5c03a4161ab53affd13/1
*/

//User function Template for Java

class Solution {
    public static boolean isPossible(int mid, int n, int k, int w, int[] a) {
        int count = 0;
        for (int i : a) {
            if (i > mid) {
                count += (i - mid + w - 1) / w;
            }
        }
        return count <= k;
    }

    long maximizeMinHeight(int n, int k, int w, int[] a) {
        // Write your code here
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i : a) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        int start = min;
        int end = max;
        long ans = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (isPossible(mid, n, k, w, a)) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }
}