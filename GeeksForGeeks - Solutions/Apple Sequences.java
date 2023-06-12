/*
Problem Link: https://practice.geeksforgeeks.org/problems/38f100615d0b2efa755e7b07f905e0f8cd2fe5df/1
*/

class Solution {
    public static int appleSequence(int n, int m, String arr) {
        // code here
        int left = 0, right = 0;
        int numOranges = 0, maxApples = 0;
        while (right < n) {
            if (arr.charAt(right) == 'O') {
                numOranges++;
            }
            while (numOranges > m) {
                if (arr.charAt(left) == 'O') {
                    numOranges--;
                }
                left++;
            }
            maxApples = Math.max(maxApples, right - left + 1);
            right++;
        }
        return maxApples;
    }
}