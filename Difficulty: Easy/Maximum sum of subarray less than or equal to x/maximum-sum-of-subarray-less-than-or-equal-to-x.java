//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String[] input = br.readLine().split(" ");
            int[] arr = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }
            long sum = Long.parseLong(br.readLine());
            Solution ob = new Solution();
            long ans = ob.findMaxSubarraySum(arr, sum);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public long findMaxSubarraySum(int[] arr, long x) {
        // Your code goes here
      int i = 0;
      int j= 0;
      long sum = 0;
      long max = 0;
      while(j<arr.length){
          sum = sum+arr[j];
          while(sum>x){
              sum =sum-arr[i];
              i++;
          }
          max = Math.max(max,sum);
          j++;
      }
      return max;
    }
}
