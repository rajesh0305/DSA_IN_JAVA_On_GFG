//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {

    int countPair(int k, int arr[]) {
        // Complete the function
        int sum=  k;
              int low=0,high=arr.length-1,count=0;
        int csum=0;  //calculated sum
        while(low<high)
        {
            csum = arr[low]+arr[high];
            if(csum==k){
                count++;
                low++;
                high--;
            }else if(csum>k){
                high--;
            }else{
                low++;
            }
        }
       return count;
    }
}


//{ Driver Code Starts.
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            String[] inputLine = br.readLine().trim().split(" ");
            int k = Integer.parseInt(inputLine[0]);

            inputLine = br.readLine().trim().split(" ");
            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            Solution obj = new Solution();
            int res = obj.countPair(k, arr);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends