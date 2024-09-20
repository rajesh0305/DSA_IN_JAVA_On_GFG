//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // consume the newline
        for (int tc = 0; tc < t; tc++) {
            String[] greedStr = sc.nextLine().split(" ");
            String[] cookieStr = sc.nextLine().split(" ");

            int[] greed = Arrays.stream(greedStr).mapToInt(Integer::parseInt).toArray();
            int[] cookie =
                Arrays.stream(cookieStr).mapToInt(Integer::parseInt).toArray();

            Solution obj = new Solution();
            System.out.println(obj.maxChildren(greed, cookie));
        }
        sc.close();
    }
}
// } Driver Code Ends



class Solution {
    public int maxChildren(int[] greed, int[] cookie) {
        // Your code goes here.
        int n = greed.length;
        int m = cookie.length;
        int l = 0;
        int r=0;
        Arrays.sort(greed);
        Arrays.sort(cookie);
        while(l<m && r<n){
            if(greed[r]<=cookie[l]){
                r = r+1;
            }
            l = l+1;
        }
        return r;
    }
}