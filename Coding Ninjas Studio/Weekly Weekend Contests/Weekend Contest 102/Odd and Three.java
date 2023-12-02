public class Solution {
    static int countMoves(int n, int[] a) {
        // Write your code here.
        int countEven = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] % 2 == 0) {
                countEven++;
            }
        }

        int steps = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] % 3 != 0) {
                if (a[i] % 3 == 1) {
                    steps += 2;
                } else {
                    steps += 1;
                }
            }
        }
        return Math.min(countEven, steps);
    }
}