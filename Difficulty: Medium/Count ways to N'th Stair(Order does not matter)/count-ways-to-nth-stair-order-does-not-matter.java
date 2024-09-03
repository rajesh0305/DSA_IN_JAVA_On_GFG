//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            long ans = ob.nthStair(n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static long find(int n,int dp[]){
        dp[0]  = 0;
        dp[1]  = 1;
        for(int i = 2;i<=n;i++){
            if((i&1)==0){
                dp[i] =1+dp[i-1];
            }else{
                dp[i] = dp[i-1];
            }
        }
        return dp[n];
    }
    public long nthStair(int n) {
        // Code here
    //   long count = 0;
    //   if(n==1){
    //       count  = count+1;
    //       return count;
    //   }
    //   long  left = nthStair(n-1);
    //   long  right = nthStair(n-2);
    //   long  ans = 1+left+right;
    //   return ans;
    int dp[] = new int[n+1];
    return find(n,dp);
    }
}