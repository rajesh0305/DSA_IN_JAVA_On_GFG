//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String x = read.readLine();
            String y = read.readLine();
            Solution ob = new Solution();
            String result = ob.findSum(x, y);

            System.out.println(result);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    String findSum(String X, String Y) {
        // code here
        // int a = Integer.valueOf(X);
        // int b = Integer.valueOf(Y);
        // int c =a+b;
        // String ans = String.valueOf(c);
        // return ans;
        // int a = Integer.parseInt(X);
        // int b = Integer.parseInt(Y);
        // int c = a+b;
        // String ans = Integer.toString(c);
        // return ans;
          return new java.math.BigInteger(X).add(new java.math.BigInteger(Y)).toString();
    }
}