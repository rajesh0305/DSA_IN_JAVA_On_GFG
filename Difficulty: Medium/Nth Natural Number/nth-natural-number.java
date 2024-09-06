//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner ob = new Scanner(System.in);
        int t = ob.nextInt();
        while (t-- > 0) {
            long n = ob.nextLong();
            Solution ab = new Solution();
            long k = ab.findNth(n);
            System.out.println(k);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    long findNth(long n) {
        // code here
        // long ans = 0;
        // int countnine = 0;
        // for(int i = 1;i<=n;i++){
        //     int last =i%10;
        //     if(last==9){
        //         countnine++;
        //     }
        // }
        // ans =n+countnine;
        // if(ans%10==9){
        //     ans = ans+1;
        // }
        // return ans;
        long b10n = n;
        long b9n = 0;
        int pos = 1;
        while(b10n>0){
            b9n = b9n+pos*(b10n%9);
            b10n =b10n/9;
            pos =pos*10;
        }
        return b9n;
    }
}