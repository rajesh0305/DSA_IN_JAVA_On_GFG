//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            String S = br.readLine();
            Solution ob = new Solution();
            String ans = ob.rremove(S).trim();
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public static String rem(String s) {
        StringBuilder ans = new StringBuilder(); 
        // Use StringBuilder for better performance
        int n = s.length();
        int i = 0;
        
        while (i < n) {
            int j = i;
            // Move j to the end of the sequence of the same characters
            while (j < n && s.charAt(i) == s.charAt(j)) {
                j++;
            }
            // If only one character is found, add it to the result
            if (j == i + 1) {
                ans.append(s.charAt(i));
            }
            // Move i to the end of the current sequence
            i = j;
        }
        
        return ans.toString();
    }

    String rremove(String s) {
        String res = "";
        while (!s.equals(res)) {
            res = s;
            s = rem(s);
        }
        return s;
    }
}