//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            String s;
            s = sc.next();
            
            Solution ob = new Solution();
            
            System.out.println(ob.reverseWords (s));    
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
 public static String optimal(String S){
            String[] arr = S.split("\\.");
        for(int i=0;i<arr.length;i++){
            String str = arr[i];
            StringBuilder reversed = new StringBuilder();
            for (int j = str.length() - 1; j >= 0; j--) {
                reversed.append(str.charAt(j));
            }
            arr[i]= reversed.toString();
        }
        String val = String.join(".",arr);
        for(int i=S.length()-1; i>=0 ;i--){
            if(S.charAt(i) == '.'){
                val = val + ".";
            }else{
                break;
            }
        }
        return val;
 }
    String reverseWords(String S)
    {
        // your code here
       
        //   // Split the string by "."
        // String[] string_array = S.split("\\.");
        // String rev = "";
        // Stack<Character> s = new Stack<>();

        // for (int i = 0; i < string_array.length; i++) {
        //     String str = string_array[i];

        //     // Push characters of the word onto the stack
        //     for (int j = 0; j < str.length(); j++) {
        //         s.push(str.charAt(j));
        //     }

        //     // Pop characters to reverse the word
        //     while (!s.isEmpty()) {
        //         rev += s.pop();
        //     }

        //     // Add a dot between reversed words, except after the last one
        //     if (i != string_array.length - 1) {
        //         rev += ".";
        //     }
        // }

        // return rev;
        
        return optimal(S);
    }
}