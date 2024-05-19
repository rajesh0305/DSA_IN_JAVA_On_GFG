//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Driverclass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int k = sc.nextInt();

            System.out.println(new Solution().countOccurence(arr, n, k));
        }
    }
}

// } Driver Code Ends


class Solution 
{
   
    //Function to find all elements in array that appear more than n/k times.
    public int countOccurence(int[] arr, int n, int k) 
    {
        // your code here,return the answer
        //Approach 1-->O(N)
        // int max =0;
        // for(int i =0;i<arr.length;i++){
        //     max = Math.max(max,arr[i]);
        // }
        // int ans[] =new int [max+1];
        // for(int i = 0;i<arr.length;i++){
        //   ans[arr[i]]++;
        // }
        // int count =0;
        // int nbyk = n/k;
        // for(int i =0;i<ans.length;i++){
        //     if(nbyk<ans[i]){
        //         count++;
        //     }
        // }
        // return count;
        
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            if(map.containsKey(arr[i])){
            map.put(arr[i],map.get(arr[i])+1);
            }else{
                map.put(arr[i],1);
            }
        }
        int ans = 0;
     for(int key : map.keySet()){
         if(map.get(key) > n/k){
             ans++;
         }
     }
        return ans;
    }
}
