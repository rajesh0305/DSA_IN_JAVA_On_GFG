//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M));
            t--;
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int celeb(int arr[][],int n,int m){
        int knowme[]= new int [n];
        int iknow[] = new int [n];
        for(int i =0;i<n;i++){
            for(int j= 0;j<n;j++){
                if(arr[i][j]==1){
                    knowme[j]++;
                    iknow[i]++;
                }
            }
        }
        int ans = -1;
        for(int i =0;i<n;i++){
            if(knowme[i]==n-1 && iknow[i]==0){
                ans =  i;
            }
        }
        return ans;
    }
    public static int celeb_optimal(int mat[][],int n){
          // int n = mat.length;
        int a =0;
        int b = n-1;
        
        
        while(a<b){
            if(mat[a][b]==1){
                a++;
            }else{
                b--;
            }
        }
        
        int candidate =a;
        for(int i=0;i<n;i++){
            if(i != candidate){
                if(mat[candidate][i] == 1 || mat[i][candidate] == 0){
                    return -1;
                }
            }
        }
        return candidate;
    }
    // Function to find if there is a celebrity in the party or not.
    public int celebrity(int mat[][]) {
        // code here
        int n = mat.length;
        int m = mat[0].length;
        //return celeb(mat,n,m);
        return celeb_optimal(mat,n);
    }
}