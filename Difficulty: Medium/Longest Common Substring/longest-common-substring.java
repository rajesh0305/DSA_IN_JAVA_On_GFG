//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            
            String S1 = read.readLine().trim();
            String S2 = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestCommonSubstr(S1, S2, n, m));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    int longestCommonSubstr(String S1, String S2, int n, int m){
        //Approach(recursion)
        
    //     if (n == 0 || m == 0) {
    //         return count;
    //     }
    
    //      if (x[n - 1] == y[m - 1]) {
    //         count = longestCommonSubstrRecursive(x, y, n - 1, m - 1, count + 1);
    //     }
    
    //     int res = max(count, max(
    //         longestCommonSubstrRecursive(x, y, n - 1, m, 0),
    //         longestCommonSubstrRecursive(x, y, n, m - 1, 0)
    //     ));
    
    //     return res;
     
     //Approach(Memorization)
     
     //     if (n == 0 || m == 0) {
    //         return count;
    //     }
    //     if(t[n][m]!=-1)
    //     return t[n][m];
    //     if (S1[n - 1] == S2[m - 1]) {
    //         t[n][m] = longestCommonSubstrRecursive(S1, S2, n - 1, m - 1, count + 1);
    //     }
    //     else
    //     t[n][m]=0;
    //     longestCommonSubstrRecursive(S1, S2, n - 1, m);
    //     longestCommonSubstrRecursive(S1, S2, n, m - 1);
    //     return t[n][m];
  
  //Approach(Top down DP)  
  
          int[][] dp = new int[n+1][m+1];
        int max = 0;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(S1.charAt(i-1) == S2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] +1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }
}