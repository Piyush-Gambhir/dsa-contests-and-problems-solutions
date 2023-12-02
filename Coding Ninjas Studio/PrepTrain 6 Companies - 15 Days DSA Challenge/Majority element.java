import java.io.*;
import java.util.*;

public class Solution {
    public static int findMajority(int[] arr, int n) {
        // Write your code here.
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(arr[i])) {
                int val = map.get(arr[i]);
                map.put(arr[i], val + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        for (int i = 0; i < n; i++) {
            if (map.get(arr[i]) > n / 2) {
                return arr[i];
            }
        }

        return -1;
    }
}