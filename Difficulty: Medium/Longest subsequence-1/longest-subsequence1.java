//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int[] a = IntArray.input(br, n);

            Solution obj = new Solution();
            int res = obj.longestSubseq(n, a);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int longestSubseq(int n, int[] a) {
        // code here
        //  int maxlen = 1;
        //  int currlen = 1;
         
        //  for(int i = 1;i<n;i++){
        //      int diff =Math.abs(a[i]-a[i-1]);
        //      if(diff==1){
        //          currlen++;
        //      }else{
        //          maxlen = Math.max(currlen,maxlen);
        //          currlen = 1;
        //      }
        //  }
        //  maxlen  = Math.max(maxlen,currlen);
        //  return maxlen;
         if (n == 0) return 0;

    // Create a dp array to store the maximum subsequence length ending at each index
    int[] dp = new int[n];
    Arrays.fill(dp, 1); // Each element is a subsequence of length 1 by itself

    int maxLen = 1;

    // Iterate through the array to fill the dp array
    for (int i = 1; i < n; i++) {
        for (int j = 0; j < i; j++) {
            if (Math.abs(a[i] - a[j]) == 1) {
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        maxLen = Math.max(maxLen, dp[i]); // Track the maximum length
    }

    return maxLen;
    }
}
