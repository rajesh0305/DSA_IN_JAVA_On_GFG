//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            String S = sc.next();

            Solution obj = new Solution();

            System.out.println(obj.CountPS(S, N));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static boolean check(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public int CountPS(String s, int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                String sub = s.substring(i, j + 1);
                if (check(sub)) {
                    count++;
                }
            }
        }
        return count;
    }
}