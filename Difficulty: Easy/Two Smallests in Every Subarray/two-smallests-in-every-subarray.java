//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int[] a = new int[s.length];
            for (int i = 0; i < s.length; i++) a[i] = Integer.parseInt(s[i]);

            Solution obj = new Solution();
            int res = obj.pairWithMaxSum(a);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public int pairWithMaxSum(int[] arr) {
        // code here
       
        if(arr.length<=1){
            return -1;
        }
         int max = arr[0]+arr[1];
        int sum= max;
        int ptr =0;
        for(int i = 2;i<arr.length;i++){
            sum = sum+arr[i];
            sum =sum-arr[ptr++];
            if(sum>max){
                max = sum;
            }
        }
        return max;
    }
}
