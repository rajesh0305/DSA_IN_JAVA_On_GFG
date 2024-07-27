//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.maxOnes(a, n));
            
        }
	}
}
// } Driver Code Ends


//User function Template for Java


class Solution {
public static void count(int arr[],int start,int last,ArrayList<Integer>ans){
     int one = 0;
     int zero = 0;
     for(int i =start;i<last-start-1;i++){
      if(arr[start]==0){
          zero++;
      }else{
          one++;
      }
     }
    ans.add(0,zero);
    ans.add(1,one);
    // return ans;
}
public static void flip(int arr[],int s,int l){
    for(int i =s;i<l-s+1;i++){
        if(arr[i]==0){
            arr[i]= 1;
        }else{
            arr[i] = 0;
        }
    }
}
public static int countOne(int arr[]){
    int count = 0;
    for(int i = 0;i<arr.length;i++){
        if(arr[i]==1){
            count++;
        }
    }
    return count;
}
    public static int maxOnes(int a[], int n) {
        // Your code goes here
        // int start = 0;
        // int last  = n-1;
        // while(start<last){
        //     if(a[start]==1 && a[last]==0){
        //         start++;
        //     }
        //     if(a[start]==0 && a[last]==1){
        //         last--;
        //     }
        //     if(a[start]==0 && a[last]==0){
        //         ArrayList<Integer>countOneZero = new ArrayList<>();
        //         count(a,start,last,countOneZero);
        //         if(countOneZero.get(0)>countOneZero.get(1)){
        //             //apply flip operation
        //             flip(a,start,last);
        //         }
        //     }
        //     start++;
        //     last--;
        // }
        // //count one now
        // return countOne(a);
           // Your code goes here
        int cnt = 0;
        for(int i=0;i<n;i++){
            if(a[i]==1){
                cnt++;
                a[i] = -1;
            }
            else{
                a[i] = 1;
            }
        }
        return cnt+kadane(a,n);
    }
    public static int kadane(int a[], int n){
        int sum = 0; int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            sum += a[i];
            max = Math.max(max, sum);
            if(sum<0){
                sum = 0;
            }
        }
        return Math.max(max, 0);
    }
}
