//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.sequence(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
      public static long find(int n , long count , long ans ,long a, long j)
    {
        if(n == 0) return ans % 1000000007;
        for(long i = 0; i < j; i++)
        {
            a = (a * count) % 1000000007;
            count ++;
        }
        ans += a;
        return find(n-1 , count , ans, 1 , j+1);
        
    }
    static long sequence(int n){
        long ans = find(n , 1 , 0 , 1 , 1);
        return ans ;
    }
}