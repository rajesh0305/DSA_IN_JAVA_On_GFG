//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    long countTriplets(int n, int sum, long arr[]) {
        // long count = 0;
        // for(int i = 0;i<arr.length;i++){
        //     for(int j = i+1;j<arr.length;j++){
        //         for(int k = j+1;k<arr.length;k++){
        //             if(arr[i]+arr[j]+arr[k]<sum){
        //                 count++;
        //             }
        //         }
        //     }
        // }
        // return count;
        Arrays.sort(arr);
        long res = 0;
        for (long i =0 ; i < n; i++) {
          long first = i+1;
          long last = n - 1;
         while(first < last)
            {
            int sum1 = 0;
            sum1 = (int) (arr[(int)first] + arr[(int)last] + arr[(int)i]); 
            if (sum1 < (long) sum) {
                res+= last -first;
                first++;
               
            } else {
                last--;
            }
        }
        }
        return res;
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
            //            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] q = line.trim().split("\\s+");
            int n = Integer.parseInt(q[0]);
            int k = Integer.parseInt(q[1]);
            //            //int y =Integer.parseInt(q[2]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(a1[i]);
            }
            //            String line2 = br.readLine();
            //            String[] a2 = line2.trim().split("\\s+");
            //            long b[] = new long[m];
            //            for (int i = 0; i < m; i++) {
            //                b[i] = Long.parseLong(a2[i]);
            //            }
            Solution ob = new Solution();
            long ans = ob.countTriplets(n, k, a);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends