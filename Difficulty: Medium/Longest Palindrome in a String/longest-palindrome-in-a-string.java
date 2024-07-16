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
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestPalin(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    public static boolean CheckPelindrom(String s,int start){
      int i = start;
      int j = s.length()-1;
      while(i<j){
          if(s.charAt(i)==s.charAt(j)){
              i++;
              j--;
          }
          if(s.charAt(i)!=s.charAt(j)){
              return false;
          }
      }
      return true;
    }
    static String longestPalin(String S){
        
//   First declaring a window of maximum size
// Sliding the window till the end of window coincides with end of string
// checking if the substring in window is pallindrome or not 
// if it is, return the substring
// if it is not, slide the window by 1
// reducing size of window by 1 until size becomes 1
// in default case return substring of length 1

   // A loop to change window size starting with max size

        for(int window=S.length(); window>0; window--){

      // another loop to traverse current window to the end

            for(int i=window-1;i<S.length();i++){
                int s=i-window+1, e=i;
                boolean flag=true;

      // checking for pallindrome
                while(s<=e){
                    if(S.charAt(s)!=S.charAt(e)){
                        flag=false;
                        break;
                    }
                    s++;
                    e--;
                }
            // returning if found
            if(flag){
                return S.substring(i-window+1, i+1);
            }
            
            }
        }
   // default return statement
        return S.substring(0,1);
    }
}