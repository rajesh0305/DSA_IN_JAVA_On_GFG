//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total testcases
		int t=sc.nextInt();
		
		sc.nextLine();
		while(t-->0)
		{
		   //taking String X and Y
		   String S[]=sc.nextLine().split(" ");
		   String X=S[0];
		   String Y=S[1];
		   
		   //calling function shortestCommonSupersequence()
		   System.out.println(new Solution().shortestCommonSupersequence(X, Y, X.length(), Y.length()));
		}
	}




       
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    // public static int helper(String x,String y,int dp[][]){
    //   int n = x.length();
    //   int m = y.length();
    //   int i =n;
    //   int j = m;
    //   String ans ="";
    //   while(i>0 && j>0){
    //       if(x.charAt(i)==y.charAt(j)){
    //           ans = ans+x.charAt(i-1);
    //           i--;
    //           j--;
    //       }else if(dp[i-1][j]>dp[i][j-1]){
    //           ans =ans+x.charAt(i-1);
    //           i--;
    //       }else{
    //           ans = ans+y.charAt(j-1);
    //           j--;
    //       }
    //   }
    //   while(i>0){
    //       ans =ans+x.charAt(i-1);
    //       i--;
    //   }
    //   while(j>0){
    //       ans = ans+y.charAt(j-1);
    //       j--;
    //   }
    //   return ans.length();
    // }
    //Function to find length of shortest common supersequence of two strings.
    public static int shortestCommonSupersequence(String X,String Y,int m,int n)
    {
        //Your code here
    //   int dp[][] = new int [m+1][n+1];
    //   for(int i = 0;i<n;i++){
    //       dp[i][0]= 0;
    //   }
    //   for(int j =0;j<m;j++){
    //       dp[0][j] = 0;
    //   }
    //   for(int i =1;i<=m;i++){
    //       for(int j = 1;j<=n;j++){
    //           if(X.charAt(i-1)==Y.charAt(j-1)){
    //               dp[i][j] = 1+dp[i-1][j-1];
    //           }else{
    //               dp[i][j] = 0+Math.max(dp[i][j-1],dp[i-1][j]);
    //           }
    //       }
    //   }
    //   int len = dp[m][n];
    //   int ans = (m+n)-len;
    //   return ans;
       int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) dp[i][j] = 0;
                else if (X.charAt(i - 1) == Y.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return m + n - dp[m][n];
    }
}