import java.util.*;

public class Solution {

    public static int[] nextGreater(int[] arr, int n) {
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }

        return ans;
    }
}
