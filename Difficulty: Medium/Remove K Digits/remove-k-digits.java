//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String S = sc.next();
            int K = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.removeKdigits(S, K));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public String removeKdigits(String S, int K) {
        // code here
        int k =K;
            int n = S.length();
        Stack<Character>s = new Stack<>();
        for(int i=0;i<n;i++){
            char ch = S.charAt(i);
            while(!s.isEmpty() && k>0 && ch<s.peek()){
                s.pop();
                k--;
            }
            if(!s.isEmpty() || ch!='0'){
                s.add(ch);
            }
        }
        while(!s.isEmpty() && k>0){
            s.pop();
            k--;
        }
        if(s.isEmpty()){
            return "0";
        }
        StringBuilder str = new StringBuilder();
        while(!s.isEmpty()){
            str.append(s.pop());
        }
        String ans = str.reverse().toString();
        return ans;
    }
}