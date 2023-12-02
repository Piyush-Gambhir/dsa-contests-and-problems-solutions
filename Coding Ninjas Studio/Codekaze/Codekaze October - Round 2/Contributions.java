/*
Problem Statement: 
You are given an array 'A' o length 'N'.
Find the sum of 'A[i] xor A[j]' for all pairs of 'i, j'
satisfying 'A[i] % 3 = A[j] % 3' and '0 <= i < j < N'.
*/

import java.util.*;

public class Solution {
    static long contributions(int n, int[] a) {
        long ans = 0;
        HashMap<Integer, Integer> countMap = new HashMap<>();
        
        for (int i = 0; i < a.length; i++) {
            int remainder = a[i] % 3;
            countMap.put(remainder, countMap.getOrDefault(remainder, 0) + 1);
        }
        
        for (int i = 0; i < a.length; i++) {
            int remainder = a[i] % 3;
            int count = countMap.get(remainder);
            countMap.put(remainder, count - 1);
            
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] % 3 == a[j] % 3) {
                    ans += a[i] ^ a[j];
                }
            }
            
            countMap.put(remainder, count);
        }
        
        return ans;
    }
}
