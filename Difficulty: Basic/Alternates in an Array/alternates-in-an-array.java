//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Long> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Long.parseLong(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (long i : array) arr[idx++] = (int)i;

            Solution obj = new Solution();

            // calling maxSubarraySum() function
            obj.print(arr);
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// arr[] is the array
// n is the number of elements in array.
class Solution {
    public static void print(int arr[]) {
        // your code here
        int i = 0;
        while(i<arr.length){
            System.out.print(arr[i]+" ");
            i = i+2;
        }
    }
}