//{ Driver Code Starts
//Initial Template for Java

import java.util.*;

public class GFG 
{
    public static void main(String args[]) 
    {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while (t-- > 0) 
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0;i < n;i++)
            {
                arr[i] = sc.nextInt();
            }
            
            Solution sol = new Solution();
            System.out.println(sol.findOnce(arr, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    int findOnce(int arr[], int n)
    {
        // Complete this function
      //  Approach 1--->O(logN)
      
        // int left=0;
        // int right=n-1;
        
        // if(n==1){
        //     return arr[0];
        // }
        
        // while(left<=right){
            
        //     int mid=(left+right)/2;
        //     //left
        //     if(mid<n-1 && mid%2==0 && arr[mid]==arr[mid+1]){
        //         left=mid+1;
        //     }
        //     else if(mid>0 && mid%2!=0 && arr[mid]==arr[mid-1]){
        //         left=mid+1;
        //     }
        //     //right
        //     else if(mid>0 && mid%2==0 && arr[mid]==arr[mid-1]){
        //         right=mid-1;
        //     }
        //     else if(mid<n-1 && mid%2!=0 && arr[mid]==arr[mid+1]) {
        //         right=mid-1;
        //     }
        //     else{
        //         return arr[mid];
        //     }
            
        // }
        // return -1;
        int ele = arr[0];
        for(int i =1;i<arr.length;i++){
            ele = ele^arr[i];
        }    
        return ele;
    }
}