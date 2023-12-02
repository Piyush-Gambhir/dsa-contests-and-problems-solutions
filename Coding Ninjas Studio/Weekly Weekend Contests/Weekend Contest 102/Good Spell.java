public class Solution {
    static int goodSpell(int n, String s) {
        // Write your code here.
        if (n % 2 != 0) {
            return 0;
        }
        int firstHalfProduct = 1;
        int secondHalfProduct = 1;
        for (int i = 0; i < n / 2; i++) {
            firstHalfProduct *= Integer.parseInt(s.charAt(i) + "");
            secondHalfProduct *= Integer.parseInt(s.charAt(i + n / 2) + "");
        }

        if (firstHalfProduct == secondHalfProduct) {
            return 1;
        } else {
            return 0;
        }
    }
}