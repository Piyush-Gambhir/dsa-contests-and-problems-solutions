/*
Problem Statement
You are given a binary tree having 'Nj nodes. Each node of the tree has an integer value. Your task is to find the maximum average of node values of any subtree of the given tree.
*/

/************************************************
    Binary Tree Node class for reference

    class TreeNode<T> {
        public T data;
        public TreeNode<T> left;
        public TreeNode<T> right;

        TreeNode(T data) {
            this.data = data;
            left = right = null;
        }

    }
 **********************************************/

import java.util.*;

public class Solution {

    private static void maxSubtreeAverageHelper(TreeNode<Integer> root, double[] maxAvg) {
        if (root == null) {
            return;
        }

        int[] left = maxSubtreeAverageHelper(root.left, maxAvg);
        int[] right = maxSubtreeAverageHelper(root.right, maxAvg);

        int sum = left[0] + right[0] + root.data;
        int count = left[1] + right[1] + 1;

        double avg = (double) sum / count;
        maxAvg[0] = Math.max(maxAvg[0], avg);
    }

    public static double maxSubtreeAverage(TreeNode<Integer> root) {
        // Write your code here.
        if (root == null) {
            return 0;
        }

        double[] maxAvg = new double[1];
        maxAvg[0] = Integer.MIN_VALUE;
        maxSubtreeAverageHelper(root, maxAvg);
        return maxAvg[0];

    }
}