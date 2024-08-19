//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.nthPoint(n);
            System.out.println(ans);            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int m = 100000000+7;
    public static int twovar(int n){
         if(n==1) return 1;
            if(n==2) return 2;
            int first=1;
            int second = 2;
            for(int i=3;i<=n;i++) {
                int temp = (first+second)%m;
                first= second;
                second = temp;
            }
            return second;
    }
    public static int TabulationMethod(int n){
        int dp[] = new int [n+1];
        if(n==0){
            return 1;
        }else if(n==1){
            return 1;
        }
        dp[0] =1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3;i<=n;i++){
            dp[i] = (dp[i-1]+dp[i-2])%m;
        }
        return dp[n];
    }
    public int nthPoint(int n)
    {
    //   if(n==0||n==1){
    //       return 1;
    //   }
    //   return nthPoint(n-1)+nthPoint(n-2);
    //return TabulationMethod(n);
    // return twovar(n);
      int a=1, b=2;
        int mod=1000000007;
        if(n<3)
            return n;
        for(int i=3;i<=n;i++){
            int temp=a;
            a=b%mod;
            b=(temp+a)%mod;
        }
        return b;
    }
}