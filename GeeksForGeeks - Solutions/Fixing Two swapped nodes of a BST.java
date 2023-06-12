/*
Probloem Link: https://practice.geeksforgeeks.org/problems/6c4053871794c5e7a0817d7eaf88d71c4bb4c2bc/1
*/

// User function Template for Java

/*
    class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
*/

class Solution {
    public Node correctBST(Node root) {
        // code here.

        Node first = null;
        Node second = null;

        Node prev = null;
        Node curr = root;
        Node next = null;

        while (curr != null) {
            next = curr.left;
            if (next != null) {
                while (next.right != null && next.right != curr) {
                    next = next.right;
                }
                if (next.right == null) {
                    next.right = curr;
                    curr = curr.left;
                } else {
                    next.right = null;
                    if (prev != null && prev.data > curr.data) {
                        if (first == null) {
                            first = prev;
                        }
                        second = curr;
                    }
                    prev = curr;
                    curr = curr.right;
                }
            } else {
                if (prev != null && prev.data > curr.data) {
                    if (first == null) {
                        first = prev;
                    }
                    second = curr;
                }
                prev = curr;
                curr = curr.right;
            }
        }

        int temp = first.data;
        first.data = second.data;
        second.data = temp;

        return root;
    }
}
