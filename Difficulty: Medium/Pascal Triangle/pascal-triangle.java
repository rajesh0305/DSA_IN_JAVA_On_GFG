//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            ArrayList<Long> ans = new Solution().nthRowOfPascalTriangle(n);
            printAns(ans);
        }
    }
    public static void printAns(ArrayList<Long> ans) {
        for (Long x : ans) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    ArrayList<Long> nthRowOfPascalTriangle(int n) {
        // code here
        // long res =1;
        // ArrayList<Long>ans= new ArrayList<Long>();
        // ans.add(res);
        // for(int i = 1;i<n;i++){
        //     res = res*(n-i);
        //     res=res/i;
        //     ans.add(res);
        // }
        // return ans;
     
             ArrayList<Long> result= new ArrayList<>();
        
        if(n==1){
            result.add(1L);
            return result;
        }
        
        int mod= (int)1e9+7;
        long[] pascalTriangle= new long[n];
        long[] pascalTriangleHelper= new long[n];
        
        
        for(int i=1;i<n;i++){
            for(int j=0;j<=i;j++){
                if(j==0 || j==i) pascalTriangle[j]=1;
                else{
                    pascalTriangle[j]=(pascalTriangleHelper[j-1]%mod+pascalTriangleHelper[j]%mod)%mod;
                }
            }
            
            pascalTriangleHelper= Arrays.copyOf(pascalTriangle,n);
        }
        
        for(long val: pascalTriangle) result.add(val);
        
        return result;
    }
}