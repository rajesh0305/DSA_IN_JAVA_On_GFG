//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.BigInteger;


// } Driver Code Ends
//User function Template for Java

class Solution{
    public static int brute(int n){
        int count =0;
      while(n>1){
          if(n%2==1){
              count = count+1;
          }
          n = n/2;
      }
      if(n==1){
          count = count+1;
      }
      return count;
    }
    public static int better(int n){
        int count = 0;
        while(n>1){
            count = count+(n&1);
            n = n>>1;
        }
        if(n==1)count = count+1;
        return count;
    }
    //counting how many number of set bit in the given number 
    public static int optimal(int n){
        int count = 0;
        while(n!=0){
            n = n&(n-1);
            count = count+1;
        }
        return count;
    }
    
    //Function to return sum of count of set bits in the integers from 1 to n.
    public static int countSetBits(int n){
    
        // Your code here
        // int ans = 0;
        // for(int i =1;i<=n;i++){
        //     //ans = ans+brute(i);
        //     //ans = ans+better(i);
        //     ans = ans+optimal(i);
        // }
        // return ans;
        if(n<=1)
        {
            return n;
        }
        int x= (int)(Math.log(n) / Math.log(2)); //no funcyion available for log2(n), so follow this approach
        return (int)(Math.pow(2,x-1)*x+n-Math.pow(2,x))+1+countSetBits((int)(n-Math.pow(2,x)));
    }
}

//{ Driver Code Starts.

// Driver code
class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();//testcases
		int x, n;
		while(t-->0) {
	        n = sc.nextInt();//input n

		    Solution obj = new Solution();

		    System.out.println(obj.countSetBits(n));//calling countSetBits() method
		}
	}
}

// } Driver Code Ends