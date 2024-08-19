//{ Driver Code Starts
//Initial template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG
{
    public static void main (String[] args)
	{
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int n = sc.nextInt();
            int arr[]= new int[n];
            for(int i=0; i<n; i++)
                arr[i] = sc.nextInt();
            Solution ob = new Solution();
            if(ob.recreationalSpot(arr,n))
                System.out.println("True");
            else
                System.out.println("False");
        }
	}
}
// } Driver Code Ends


//User function template for C++

class Solution{
    static boolean recreationalSpot(int[] arr , int n){
        // Your code goes here 
        // for(int i = 0;i<arr.length;i++){
        //     int f =arr[i];
        //     for(int j = i+1;j<arr.length;i++){
        //         int s = arr[j];
        //         for(int k = j+1;k<arr.length;k++){
        //             if(arr[k]<s && arr[k]>f ){
        //                 return true;
        //             }
        //         }
        //     }
        // }
        // return false;
         if(n<3)return false;
        int maxi=arr[1];
        int mini=arr[0];
        for(int i=2;i<n;i++){
            if(arr[i]<maxi && arr[i]>mini)return true;
             maxi=Math.max(arr[i],maxi);
            if(mini>arr[i-1] && arr[i-1]!=maxi)mini=arr[i-1];
        }
        return false;
    }
};