//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine().trim());
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public static String comparator(String str1,String str2){
        int i = 0;
        int j =0;
        String s = "";
        while(i<str1.length() && j<str2.length()){
            if(str1.charAt(i)==str2.charAt(j)){
                s = s+String.valueOf(str1.charAt(i));
            }else{
                return s;
            }
            i++;
            j++;
        }
        return s;
    }
    String longestCommonPrefix(String arr[], int n){
        // code here
        //Approach 1(o(nlogn))
        
    //       if (arr == null || arr.length == 0)
    //         return "-1";
    //     Arrays.sort(arr);
    //     String str1 = arr[0];
    //     String str2 = arr[arr.length - 1];
    //     int man = Math.min(str1.length(), str2.length());
    //     // StringBuilder ans = new StringBuilder();
    //   String ans = "";
    //     for (int i = 0; i < man; i++) {
    //         if (str1.charAt(i) == str2.charAt(i)) {
    //             ans = ans+str1.charAt(i);
    //         } else {
    //             break;
    //         }
    //     }
    //     if(ans.equals(""))return "-1";
    //     return ans;
        
        
        //Approach 2(O(n*s))
        
        String ans=arr[0];
        
        for(int i = 0;i<arr.length-1;i++){
           String  str = comparator(ans,arr[i+1]);
            if(str.equals("")){
                return "-1";
            }
                ans = str;
        }
       
        return ans;
        
    }
}