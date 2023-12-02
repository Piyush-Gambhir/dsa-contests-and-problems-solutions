
/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;
*/

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

import java.util.*;
import java.lang.*;

class TestClass {
    private static boolean isWinningPosition(int N1, int N2) {
        // Base Cases
        if (N1 == 0 && N2 == 0) {
            return false;
        }

        if (N1 == 0 || N2 == 0) {
            return true;
        }

        if (N1 == N2) {
            return false;
        }
        

        for (int k = 1; k <= Math.min(N1, N2); k++) {
            if (!isWinningPosition(N1 - k, N2 - k) || !isWinningPosition(N1 - k, N2)
                    || !isWinningPosition(N1, N2 - k)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]) throws Exception {

        /* Sample code to perform I/O:
        * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        */
        
        // Write your code here
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N1 = sc.nextInt();
            int N2 = sc.nextInt();
            if (isWinningPosition(N1, N2)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}