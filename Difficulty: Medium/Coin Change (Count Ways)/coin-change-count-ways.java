//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int sum = sc.nextInt();
            int N = sc.nextInt();
            int coins[] = new int[N];
            for (int i = 0; i < N; i++) coins[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.count(coins, N, sum));
        }
    }
}


// } Driver Code Ends


// User function Template for Java

class Solution {
 public static int changeCoin(int coins[], int n, int dp[]) {
        if (n == 0) {
            return 0; // Base case: 0 coins needed for sum 0
        }

        int ans = Integer.MAX_VALUE;

        // Iterate through each coin
        for (int i = 0; i < coins.length; i++) {
            // Check if the coin can be used
            if (n - coins[i] >= 0) {
                int subAns = 0;
                // If already calculated, use the stored value
                if (dp[n - coins[i]] != -1) {
                    subAns = dp[n - coins[i]];
                } else {
                    // Recursively calculate for the remaining sum
                    subAns = changeCoin(coins, n - coins[i], dp);
                }
                // Check if we found a valid solution
                if (subAns != Integer.MAX_VALUE && subAns + 1 < ans) {
                    ans = subAns + 1; // Take the current coin
                }
            }
        }

        // Store the result in dp array
        return dp[n] = ans;
    }
    public long count(int coins[], int N, int sum) {
        if(sum==0){
            return 0;
        }
       long[] dp = new long[sum+1];
        dp[0] = 1;
        
        for(int i=0;i<N;i++){
            for(int j=1;j<sum+1;j++){
                int coinValue = coins[i];
                
                if(j-coinValue>=0){
                    dp[j] = dp[j] + dp[j-coinValue];
                }
            }
        }   
        return dp[sum];
    }
}