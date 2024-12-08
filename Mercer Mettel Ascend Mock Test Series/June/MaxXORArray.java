import java.io.*;
import java.util.*;

class UserMainCode {
    public int MaxORArray(int[] input1, int input2) {
        // Calculate the overall OR of the entire array
        int overallOR = 0;
        for (int num : input1) {
            overallOR |= num;
        }

        // Variable to store the maximum length of subarray that can be removed
        int maxLength = 0;

        // Iterate over all possible subarrays
        for (int i = 0; i < input2; i++) {
            for (int j = i; j < input2; j++) {
                // Compute OR of the subarray to be removed
                int subarrayOR = 0;
                for (int k = i; k <= j; k++) {
                    subarrayOR |= input1[k];
                }

                // Compute OR of the remaining array after removing subarray
                int remainingOR = 0;
                for (int k = 0; k < i; k++) {
                    remainingOR |= input1[k];
                }
                for (int k = j + 1; k < input2; k++) {
                    remainingOR |= input1[k];
                }

                // Check if the OR of the remaining array is equal to the overall OR
                if (remainingOR == overallOR) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }

        // Return the maximum length of subarray that can be removed
        return maxLength;
    }
}
