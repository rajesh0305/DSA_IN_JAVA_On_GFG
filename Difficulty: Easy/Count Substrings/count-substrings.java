//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String s = sc.next();

    		System.out.println (new Solution().countSubstr (s));
        }
        
    }
}

// Contributed By: Pranay Bansal

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static boolean check(String s){
        int n = s.length();
        boolean ans = false;
        if(n<=1){
            ans = false;
            return ans;
        }else if(n>1){
            char start = s.charAt(0);
            char end = s.charAt(n-1);
            if(start=='1' &&end=='1'){
            ans = true;
            }
        }
        return ans;
        
    }
    public static int optimal(String s){
        int count = 0;
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='1'){
                count = count+1;
            }
        }
        int res = count*(count-1)/2;
        return res;
    }
    int countSubstr (String S)
    {
        // your code here 
    //   int n = S.length();
    //   String s = "";
    //   int count = 0;
    //   // Iterate over all possible starting points
    // for (int i = 0; i < n; i++) {
    //     // Iterate over all possible ending points
    //     for (int j = i + 1; j <= n; j++) {
    //           s = S.substring(i, j);
    //         boolean flag = check(s);
    //         if (flag == true) {
    //             count = count + 1;
    //         }
    //     }
    // }
    //   return count;
    return optimal(S);
    }
}