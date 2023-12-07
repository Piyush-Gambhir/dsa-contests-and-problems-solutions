/*
Problem Link: https://practice.geeksforgeeks.org/problems/2d3fc3651507fc0c6bd1fa43861e0d1c43d4b8a1/1 
*/

// Given two arrays A[] and B[] of same length N. There are N types of sticks of
// lengths specified. Each stick of length A[i] is present in B[i] units (i=1 to
// N). You have to construct the squares and rectangles using these sticks. Each
// unit of a stick can be used as length or breadth of a rectangle or as a side
// of square. A single unit of a stick can be used only once.

// Let S be the sum of lengths of all sticks that are used in constructing
// squares and rectangles. The task is to calulate the maximum possible value of
// S.

// Note: The element in array A[] is always unique.

// Example 1:

//User function Template for Java
class Solution {
    long maxPossibleValue(int N, int A[], int B[]) {
        // code here

        long sum = 0;
        for (int i = 0; i < N; i++) {
            int len = A[i];
            int freq = B[i];

            long side = (long) Math.sqrt(len);
            long side2 = (long) Math.sqrt(side);

            if (side * side == len) {
                sum += (side * Math.min(4, freq));
            } else if (side * side2 == len) {
                sum += (side2 * Math.min(2, freq));
            } else if (side2 * side2 == len) {
                sum += (side2 * Math.min(1, freq));
            }

        }

        return sum;
    }
}
