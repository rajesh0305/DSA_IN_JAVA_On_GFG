//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {

    String roundToNearest(String str) {
        // Complete the function
   StringBuilder sb = new StringBuilder();
        int i = str.length()-2;
        int carry = 0;
        if(str.charAt(i+1) > '5'){
            carry = 1;
        }
        sb.append("0");
        while(i>=0 || carry == 1){
            int sum = carry;
            if(i>=0){
                sum += str.charAt(i) - 48;
            }
            sb.append(String.valueOf(sum%10));
            carry = sum / 10;
            i--;
        }
        return sb.reverse().toString();
    }
}


//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());

        // looping through all testcases
        while (testcases-- > 0) {

            String str = br.readLine().trim();

            Solution obj = new Solution();

            String res = obj.roundToNearest(str);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends