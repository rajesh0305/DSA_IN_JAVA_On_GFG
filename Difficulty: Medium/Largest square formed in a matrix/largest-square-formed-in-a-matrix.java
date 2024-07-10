//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int mat[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    mat[i][j] = sc.nextInt();
                }
            }
            Solution ob = new Solution();
            System.out.println(ob.maxSquare(n, m, mat));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // public static int solveProblem(int mat[][],int i,int j,int maxi){
    //     if(i>=mat.length || j>=mat[0].length){
    //         return 0;
    //     }
    //     int right = solveProblem(mat,i,j+1,maxi);
    //     int diagonal = solveProblem(mat,i+1,j+1,maxi);
    //     int down = solveProblem(mat,i+1,j,maxi);
        
    //     if(mat[i][j]==1){
    //         int ans =1+Math.min(right,Math.min(down,diagonal));
    //         maxi =Math.max(maxi,ans);
    //         return ans;
    //     }
    //     else
    //     return 0;
    // }
    
    public static int solveProblemMemo(int mat[][],int i,int j,int maxi,int dp[][]){
        if(i>=mat.length || j>=mat[0].length){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int right = solveProblemMemo(mat,i,j+1,maxi,dp);
        int diagonal = solveProblemMemo(mat,i+1,j+1,maxi,dp);
        int down = solveProblemMemo(mat,i+1,j,maxi,dp);
        
        if(mat[i][j]==1){
            dp[i][j] = 1+Math.min(right,Math.min(diagonal,down));
            maxi=  Math.max(maxi,dp[i][j]);
            return dp[i][j];
        }else{
            return dp[i][j]=0;
        
    }
    }
    static int maxSquare(int n, int m, int mat[][]) {
        // code here
    //     int maxi = 0;
    //     int i = 0;
    //     int j = 0;
    //     // return solveProblem(mat,i,j,maxi);
    //   int dp[][]= new int [n][m];
    //       for(int l =0;l<n;l++){
    //         for(int k= 0;k<m;k++){
    //             dp[l][k] = -1;
    //         }
    //     }
    //   return solveProblemMemo(mat,i,j,maxi,dp);
    
     int ans=0;
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(mat[i][j]==1){
                    if(mat[i][j-1]>0 &&
                    mat[i-1][j-1]>0 && 
                    mat[i-1][j]>0){
                        mat[i][j]=Math.min(mat[i-1][j-1],Math.min(mat[i-1][j],mat[i][j-1]))+1;    
                    }
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans=Math.max(ans,mat[i][j]);
            }
        }
        return ans;
    }
}