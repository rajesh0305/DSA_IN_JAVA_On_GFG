//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int arr[][] = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            new Solution().setMatrixZeroes(arr);
            for (int[] row : arr) {
                for (int val : row) {
                    System.out.print(val + " ");
                }
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends


//Back-end complete function Template for Java
class Solution {
    public static void row(int i,int arr[][],int n){
        for(int j = 0;j<n;j++){
            if(arr[i][j]!=0){
                arr[i][j]=-1;
            }
        }
    }
    public static void col(int j,int arr[][],int n){
        for(int i =0;i<n;i++){
            if(arr[i][j]!=0){
                arr[i][j]=-1;
            }
        }
    }
    public void setMatrixZeroes(int[][] arr) {
        // int n = arr.length;
        // int m = arr[0].length;
        // for(int i = 0;i<n;i++){
        //     for(int j = 0;j<m;j++){
        //         if(arr[i][i]==0){
        //             row(i,arr,m);
        //             col(j,arr,n);
        //         }
        //     }
        // }
        // for(int i = 0;i<n;i++){
        //     for(int j = 0;j<m;j++){
        //         if(arr[i][j]==-1){
        //             arr[i][j]=0;
        //         }
        //     }
        // }
        int n = arr.length;
        int m = arr[0].length;
        
        boolean firstRowZero = false;
        boolean firstColZero = false;
        
        for (int i = 0; i < n; i++) {
            if (arr[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }
        
        for (int j = 0; j < m; j++) {
            if (arr[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (arr[i][j] == 0) {
                    arr[i][0] = 0;
                    arr[0][j] = 0;
                }
            }
        }
        
        for (int i = 1; i < n; i++) {
            if (arr[i][0] == 0) {
                for (int j = 1; j < m; j++) {
                    arr[i][j] = 0;
                }
            }
        }
        
        for (int j = 1; j < m; j++) {
            if (arr[0][j] == 0) {
                for (int i = 1; i < n; i++) {
                    arr[i][j] = 0;
                }
            }
        }
        
        if (firstRowZero) {
            for (int j = 0; j < m; j++) {
                arr[0][j] = 0;
            }
        }
        
        if (firstColZero) {
            for (int i = 0; i < n; i++) {
                arr[i][0] = 0;
            }
        }
    }
}