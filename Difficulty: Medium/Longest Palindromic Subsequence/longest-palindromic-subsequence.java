//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.longestPalinSubseq(s));
                }
                
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static String findReverse(String s){
        int n = s.length()-1;
        int i = n;
        String ans ="";
        while(i>=0){
            char ch = s.charAt(i);
            ans = ans+ch;
            i--;
        }
        return ans;
    }
    public static int find_Length_of_LCS(String s,String t){
        int n = s.length();
        int m = t.length();
        int dp[][] =new int [n+1][m+1];
        //  for(int i = 0;i<n;i++){
        //      dp[i][0] = 0;
        //  }
        //  for(int i = 0;i<m;i++){
        //      dp[0][i] =0;
        //  }
         for(int i = 1;i<=n;i++){
             for(int j = 1;j<=m;j++){
                 if(s.charAt(i-1)==t.charAt(j-1)){
                     dp[i][j] =1+dp[i-1][j-1];
                 }else{
                     dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                 }
             }
         }
         return dp[n][m];
    }
    public int longestPalinSubseq(String S)
    {
        //code here
        String rev = findReverse(S);
        int len =find_Length_of_LCS(S,rev);
        return len;
    }
}