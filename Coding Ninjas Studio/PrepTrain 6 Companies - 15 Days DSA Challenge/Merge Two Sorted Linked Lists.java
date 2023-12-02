import java.io.*;
import java.util.*;

/************************************************************
 * 
 * Following is the linked list node structure:
 * 
 * class LinkedListNode<T> {
 * T data;
 * LinkedListNode<T> next;
 * 
 * public LinkedListNode(T data) {
 * this.data = data;
 * }
 * }
 * 
 ************************************************************/

public class Solution {
    public static LinkedListNode<Integer> sortTwoLists(LinkedListNode<Integer> first, LinkedListNode<Integer> second) {
        // Write your code here.
        LinkedListNode<Integer> newLinkedListHead = new LinkedListNode<Integer>(0);
        LinkedListNode<Integer> temp = newLinkedListHead;

        while (first != null && second != null) {
            if (first.data <= second.data) {
                temp.next = first;
                first = first.next;
            } else {
                temp.next = second;
                second = second.next;
            }
            temp = temp.next;
        }

        if (first == null) {
            temp.next = second;
        } else {
            temp.next = first;
        }

        return newLinkedListHead.next;
    }
}
