//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            System.out.println(new Solution().maxIndexDiff(arr, n));
        }
    }
}
// } Driver Code Ends


class Solution {
 public static int find(int ele,int arr[],int start,int end,int idx){
     int max =Integer.MIN_VALUE;
     for(int i = start;i<end;i++){
         if(idx<=i && arr[idx]<=arr[i]){
             int index = i-idx;
             max = Math.max(max,index);
         }
     }
     return max;
 }
    int maxIndexDiff(int arr[], int n) {
        // int max = 0;
        // for(int i = 0;i<arr.length;i++){
        //     int ele = arr[i];
        //     int intermax = find(ele,arr,i+1,arr.length,i);
        //     max = Math.max(max,intermax);
        // }
        // return max;
                int l[] = new int[n];
        l[0] = arr[0];
        int r[] = new int[n];
        r[n-1] = arr[n-1];
        for(int i = 1; i < n ; i++){
            l[i] = Math.min(l[i-1],arr[i]);
        }
        for(int i = n-2 ; i >= 0 ; i--){
            r[i] = Math.max(r[i+1],arr[i]);
        }
        int i =0;
        int j = 0;
        int max = Integer.MIN_VALUE;
        while(i < n && j < n){
            if(l[i] <= r[j]){
                max = Math.max(max,j-i);
                j++;
            }else i++;
        }
        return max;
    }
}