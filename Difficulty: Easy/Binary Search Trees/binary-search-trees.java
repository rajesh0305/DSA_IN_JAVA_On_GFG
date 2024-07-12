//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            boolean ans = obj.isBSTTraversal(a);
            System.out.println(ans ? "True" : "False");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static boolean isBSTTraversal(int arr[]) {
        // code here
        boolean flag = false;
        for(int i = 0;i<arr.length-1;i++){
            if(arr[i]<arr[i+1]){
                flag= true;
            }else{
                flag = false;
                break;
            }
        }
        return flag;
    }
}
