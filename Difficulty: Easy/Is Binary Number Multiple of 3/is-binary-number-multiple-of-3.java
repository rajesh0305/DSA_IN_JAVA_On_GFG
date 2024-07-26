//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])throws IOException
        {
            BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out=new PrintWriter(System.out);
            int t = Integer.parseInt(in.readLine().trim());
            while(t-->0)
                {
                    String s = in.readLine().trim();
                    Solution ob = new Solution();
                    out.println(ob.isDivisible(s));
                }
                out.close();
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution {
    int isDivisible(String s) {
    //     // code here
    //     int sum = 0;
    //     int ans =0;
    //     int digit = s.length()-1;
    //     for(int i = 0;i<s.length();i++){
    //         char ch = s.charAt(i);
    //         if(ch!='0'){
    //             sum = sum+1*(int)Math.pow(2,digit);
    //             digit = digit-1;
    //         }
    //     }
    //   if(sum%3==0){
    //       ans = 1;
    //   }
    //   return ans;
        int evenSum = 0, oddSum = 0;
        int n = s.length();

        // Traverse the binary number and calculate even and odd-positioned digits' sums
        for (int i = 0; i < n; i++) {
            int digit = s.charAt(i) - '0';
            if (i % 2 == 0) {
                evenSum += digit;
            } else {
                oddSum += digit;
            }
        }

        // Check if the difference between evenSum and oddSum is divisible by 3
        int diff = Math.abs(evenSum - oddSum);
        return diff % 3 == 0 ? 1 : 0;
    }
}