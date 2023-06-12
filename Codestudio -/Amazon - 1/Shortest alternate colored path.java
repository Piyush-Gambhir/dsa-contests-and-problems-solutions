/*
Problem Statement
Consider a directed graph of 'N' nodes where each node is labeled from 'Ot to 'N - 1'. Each edge of the graph is either 'redt or 'blue' colored. The graph may contain self-edges or parallel edges. You are given two arrays, •redEdges' and 'blueEdges', whose each selement is of the form [i, j], denoting an edge from node 'i' to node 'jt of the respective color.

Your task is to compute an array 'answer' of size 'N', where 'answer[lT stores the length of the shortest path from node 'O' to node 'i' such that the edges along the path have alternate colors. If there is no such path from node 'O' to 'it, then •answer[i] = -1'.

Example:
N = 4, redEdges — [[0, 1], [2, 3]]
blueEdges — [[1, 2], [1, 3]]
*/

import java.util.ArrayList;

public class Solution {
    public static ArrayList<Integer> shortestAlternateColoredPath(int n, int redEdges[][], int blueEdges[][]) {
        // Write your code here.
    }
}