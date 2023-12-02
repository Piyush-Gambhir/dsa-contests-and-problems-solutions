import java.util.*;
import java.io.*;

import java.util.ArrayList;

public class Solution {
    public static ArrayList<Integer> maximumsumSubarray(int n, int arr[]) {
        // Write your code here

        int max_subarray_sum = Integer.MIN_VALUE;
        int max_subarray_start = 0;
        int max_subarray_end = 0;

        int current_subarray_sum = 0;
        int current_subarray_start = 0;
        int current_subarray_end = 0;

        for (int i = 0; i < n; i++) {
            current_subarray_sum += arr[i];
            current_subarray_end = i;

            if (current_subarray_sum > max_subarray_sum) {
                max_subarray_sum = current_subarray_sum;
                max_subarray_start = current_subarray_start;
                max_subarray_end = current_subarray_end;
            }

            if (current_subarray_sum < 0) {
                current_subarray_sum = 0;
                current_subarray_start = i + 1;
                current_subarray_end = i + 1;
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = max_subarray_start; i <= max_subarray_end; i++) {
            ans.add(arr[i]);
        }
        return ans;
    }
}
