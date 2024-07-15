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
                    int n = sc.nextInt();
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    
// } Driver Code Ends


class Solution{

	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    // Your code goes here
   int MOD=1000000007;
    int dp[][]=new int[n][sum+1];
    for(int i=0;i<n;i++)
    {
        dp[i][0]=1;
    }
    if(arr[0]==0)  dp[0][0]=2; 
    else if(arr[0]<=sum)  dp[0][arr[0]]=1;
    for(int ind=1;ind<n;ind++)
    {
        for(int s=0;s<=sum;s++)
        {
            int nottake=dp[ind-1][s];
            int take=0;
            if(arr[ind]<=s)
            {
                take=dp[ind-1][s-arr[ind]];
            }
            dp[ind][s]=(nottake+take)%MOD;
        }
    }
    return dp[n-1][sum];	 
	} 
}