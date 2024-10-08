//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String str1 = sc.next();
            String str2 = sc.next();

            Solution obj = new Solution();
            String ans = obj.betterString(str1, str2);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static String betterString(String str1, String str2) {
        // Code here
            //
        // Count distinct subsequences for each string
        int count1 = countDistinctSubsequences(str1);
        int count2 = countDistinctSubsequences(str2);

        // Compare counts and return the better string
        return (count1 >= count2) ? str1 : str2;
    }

    // Method to count distinct subsequences using dynamic programming
    private static int countDistinctSubsequences(String str) {
        int MOD = 1000000007;
        int n = str.length();
        
        // Array to store the last occurrence index of each character
        int[] lastOccurrence = new int[256];
        Arrays.fill(lastOccurrence, -1);

        // Dynamic programming array to store count of distinct subsequences
        int[] dp = new int[n + 1];
        dp[0] = 1; // Base case: empty string has one subsequence

        // Iterate through each character of the string
        for (int i = 1; i <= n; i++) {
            // Calculate count based on the recurrence relation
            dp[i] = (2 * dp[i - 1]) % MOD;

            // Subtract count of subsequences ending at the last occurrence of the current character
            if (lastOccurrence[str.charAt(i - 1)] != -1) {
                dp[i] = (dp[i] - dp[lastOccurrence[str.charAt(i - 1)] - 1] + MOD) % MOD;
            }

            // Update last occurrence index of the current character
            lastOccurrence[str.charAt(i - 1)] = i;
        }

        // Return the final count of distinct subsequences
        return dp[n];
    }
}