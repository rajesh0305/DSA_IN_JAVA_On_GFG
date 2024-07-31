//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static String UsingSort(String arr[]){
        int n= arr.length;
        if(n==0){
            return "";
        }
        if(n==1){
            return arr[0];
        }
        Arrays.sort(arr);
        int end= Math.min(arr[0].length(),arr[n-1].length());
        
        int i= 0;
        while(i<end && arr[0].charAt(i)==arr[n-1].charAt(i)){
            i++;
        }
        String pre = arr[0].substring(0,i);
        return pre;
    }
    public static String Helper(String str1,String str2){
           String result = "";
        int n1 = str1.length(), n2 = str2.length();
 
        for (int i = 0, j = 0; i <= n1 - 1 && 
                j <= n2 - 1; i++, j++) {
            if (str1.charAt(i) != str2.charAt(j)) {
                break;
            }
            result += str1.charAt(i);
        }
        return (result);
    }
    public static String DivideAndConquer(String arr[],int low,int high){
        if(low==high){
            return (arr[low]);
        }
        while(low<high){
            int mid = low+(high-low)/2;
            
            String str1 = DivideAndConquer(arr,low,mid);
            String str2 = DivideAndConquer(arr,mid+1,high);
            
            return (Helper(str1,str2));
        }
        return "";
    }
    public String longestCommonPrefix(String arr[]) {
        // code here
       // return UsingSort(arr);
      // return DivideAndConquer(arr,0,arr.length);
          String prefix = arr[0];
        for(int i = 1; i<arr.length; i++){
            while(arr[i].indexOf(prefix) != 0){
                prefix = prefix.substring(0, prefix.length()-1);
            }
        }
        return prefix.length()==0 ? "-1": prefix;
    }
}