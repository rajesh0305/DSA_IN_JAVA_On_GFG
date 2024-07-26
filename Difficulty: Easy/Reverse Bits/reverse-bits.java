//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            Long X = Long.parseLong(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.reversedBits(X));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
//     public static long reversedBits1(long x){
//         String str =long.toBinarySting(x);
//         long ans=0;
//         int p =31;
//          for(int i=str.length()-1;i>=0;i--){
//             if(str.charAt(i)=='1'){
//           String s=String.valueOf(str.chaAt(i));
//             int j=Integer.parseInt(s);
//             ans+=j*Math.pow(2,p);}
//             p--;
             
//          }
// return ans;
// }
    static Long reversedBits(Long x) {
        // code here
    long ans = 0;
        for (int i = 0; i <32; i++) {
           ans<<=1;
           ans|=(x&1);
           x>>=1;
        }
        return ans;
    }
};