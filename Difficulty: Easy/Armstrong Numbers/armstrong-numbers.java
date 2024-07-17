//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.armstrongNumber(n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    static String armstrongNumber(int n) {
        // code here
        int temp = n;
        double res = 0;
        String ans = "";
        while(temp>0){
            int last=temp%10;
            res = res+Math.pow(last,3);
            temp = temp/10;
        }
        if(res==n){
            ans = ans+"true";
        }else{
            ans = ans+"false";
        }
        return ans ;
    }
}