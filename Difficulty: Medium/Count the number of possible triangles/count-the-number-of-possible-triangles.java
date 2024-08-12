//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total count of testcases
        int t = sc.nextInt();
        
        while(t > 0)
        {
            //taking elements count
            int n = sc.nextInt();
            
            //creating an array of length n
            int arr[] = new int[n];
            
            //adding elements to the array
            for(int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
            
            //creating an object of class Solutions
            Solution ob = new Solution();
            
            //calling the method findNumberOfTriangles()
            //of class Solutions and printing the results
            System.out.println(ob.findNumberOfTriangles(arr,n));
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to count the number of possible triangles.
    static int findNumberOfTriangles(int arr[], int n)
    {
        // code here
        // int count = 0;
        // for(int i = 0;i<arr.length;i++){
        //     for(int j = i+1;j<arr.length;j++){
        //         for(int k = j+1;k<arr.length;k++){
        //             if(arr[i]+arr[j]>arr[k] && arr[i]+arr[k]>arr[j] && arr[j]+arr[k]>arr[i]){
        //                 count =count+1;
        //             }
        //         }
        //     }
        // }
        // return count;
        int count = 0;
        Arrays.sort(arr);
        for(int i =n-1;i>=0;i--){
            int start = 0;
            int end = i-1;
            while(start<end){
                if(arr[start]+arr[end]>arr[i]){
                    int no_of_ele =end-start;
                    count = count+no_of_ele;
                    end--;
                }else{
                    start++;
                }
            }
        }
        return count;
    }
}