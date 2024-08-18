//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] s = br.readLine().trim().split(" ");

            int[] arr = new int[s.length];
            for (int i = 0; i < arr.length; i++) arr[i] = Integer.parseInt(s[i]);

            Solution obj = new Solution();
            boolean res = obj.canSplit(arr);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static boolean optimal(int arr[]){
    int sum = 0;
    for(int i = 0;i<arr.length;i++){
        sum = sum+arr[i];
    }
    if(sum%2!=0){
        return false;
    }
    int presum = sum/2;
    int currsum = 0;
    for(int i = 0;i<arr.length;i++){
        currsum = currsum+arr[i];
        if(currsum==presum){
            return true;
        }
    }
    return false;
    }
    public boolean canSplit(int arr[]) {
        // code here
       // int n = arr.length-1;
        int i = 0;
        int j= arr.length-1;
        int s1= arr[i];
        int s2 = arr[j];
        while(i<j){
            if(s1==s2){
                i = i+1;
            if(i>=j){
                return (s1==s2);
            }
            j--;
            s1 = s1+arr[i];
            s2 = s2+arr[j];
            }else if(s1<s2){
                i++;
                s1 = s1+arr[i];
            }else{
                j--;
                s2 = s2+arr[j];
            }
        }
        return false;
    }
}