import java.util.*;

public class Solution {
    private static final int MAX_LENGTH = 10000;

    public static int calculateMinStringFactor(String inputString, String targetString, int substitutionCost,
            int reversalCost) {
        int n = inputString.length();

        int[] dp = new int[MAX_LENGTH + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = i; j > 0; j--) {
                String subStr = inputString.substring(i - j, i);

                if (isSubstringPresent(targetString, subStr)) {
                    dp[i] = Math.min(dp[i], dp[i - j] + substitutionCost);
                }

                String revSubStr = reverseString(subStr);

                if (isSubstringPresent(targetString, revSubStr)) {
                    dp[i] = Math.min(dp[i], dp[i - j] + reversalCost);
                }
            }
        }

        if (dp[n] == Integer.MAX_VALUE) {
            return -1;
        }

        return dp[n];
    }

    private static boolean isSubstringPresent(String str, String subStr) {
        int m = str.length();
        int n = subStr.length();

        for (int i = 0; i <= m - n; i++) {
            int j;
            for (j = 0; j < n; j++) {
                if (str.charAt(i + j) != subStr.charAt(j)) {
                    break;
                }
            }
            if (j == n) {
                return true;
            }
        }
        return false;
    }

    private static String reverseString(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String inputString = sc.next();
        String targetString = sc.next();
        int substitutionCost = sc.nextInt();
        int reversalCost = sc.nextInt();

        System.out.println(calculateMinStringFactor(inputString, targetString, substitutionCost, reversalCost));
    }

}
