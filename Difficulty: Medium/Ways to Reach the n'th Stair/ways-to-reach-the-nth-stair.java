//{ Driver Code Starts
import java.io.*;
import java.util.*;


class GFG {
	public static void main (String[] args) {
		
		//taking input using Scanner class
		Scanner sc = new Scanner(System.in);
		
		//taking total testcases
		int t = sc.nextInt();
		
		while(t-- > 0){
		    
		    //taking count of stairs
		    int m = sc.nextInt();
		    
		    //creating an object of class DynamicProgramming
		    Solution obj = new Solution();
		    
		    //calling method countWays() of class
		    //DynamicProgramming
		    System.out.println(obj.countWays(m));
		    
		}
		
	}
}
// } Driver Code Ends


class Solution{
    //Function to count number of ways to reach the nth stair.
    int mod = 1000000007;
    int countWays(int n){
        
        // --> Memorization :-
        
            // int[] dp = new int[n+1];
            // Arrays.fill( dp , -1);
            // return helper( n , dp) % mod;
        
        // Tabulation :-
        
            // int[] dp = new int[n+1];
            // dp[0] = dp[1] = 1;
            
            // for( int i=2 ; i <= n ; i++ ) {
            //     dp[i] = dp[i-1]%mod + dp[i-2]%mod;
            // }
            
            // return dp[n]%mod;
            
        // Space Optimized :-
            
            int prev = 1 , prev2 = 1;
            int cur;
            for( int i=2 ; i <= n ; i++ ){
                cur = prev%mod + prev2 % mod;
                prev2 = prev;
                prev = cur;
            }
            
            return prev % mod;
    }
    
    // --> Memorization :-
    
        // public int helper( int n , int[] dp){
            
        //     if(n == 0 ) return 1;
        //     if( n == 1 ) return 1;
            
        //     if( dp[n] != -1 ) return dp[n];
            
        //     return dp[n] = helper(n-1 , dp)%mod + helper(n-2 , dp)%mod;
        // }
}

