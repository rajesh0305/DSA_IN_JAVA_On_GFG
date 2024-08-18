//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            int ans = ob.smallestSubstring(S);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int smallestSubstring(String S) {
        // Code here
        int zero = 0;
        int one   = 0;
        int two = 0;
        int l = 0;
       // int r = 0;
        int ans = -1;
        for(int r = 0;r<S.length();r++){
            char ch = S.charAt(r);
            if(ch=='0'){
                zero++;
            }else if(ch=='1'){
                one++;
            }else{
                two++;
            }
            while(zero>=1 && one>=1 && two>=1){
                if(ans==-1){
                    ans =r-l+1;
                }else{
                    ans = Math.min(ans,r-l+1);
                }
                char ch1 = S.charAt(l);
                if(ch1=='0'){
                    zero--;
                }else if(ch1=='1'){
                    one--;
                }else{
                    two--;
                }
                l++;
            }
        }
        return ans;
    }
};
