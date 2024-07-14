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
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.isHappy(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution { 
  public static int get(int n){
      int sum = 0;
      while(n>0){
          int digit= n%10;
          sum = sum+(digit*digit);
          n = n/10;
      }
      return sum;
  }
     static int isHappy(int N) { 
         //code here
      ArrayList<Integer> seen = new ArrayList<>();
        while (N != 1 && !seen.contains(N)) {
            seen.add(N);
            N = get(N);
        }
        if(N!=1) {
            return 0;
        }
         return N;
     }
     
    //  private static int getNextNumber(int n) {
    //     int sum = 0;
    //     while (n > 0) {
    //         int digit = n % 10;
    //         sum += digit * digit;
    //         n /= 10;
    //     }
    //     return sum
     
     
}