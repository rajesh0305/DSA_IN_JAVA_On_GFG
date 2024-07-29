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
            String s = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestUniqueSubsttr(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution{
    int longestUniqueSubsttr(String S){
           int i=0;
        int j=0; 
      int maxlen=0;
      ArrayList<Character>list=new ArrayList<>();
      while(j<S.length()){
            if(!list.contains(S.charAt(j))){
                list.add(S.charAt(j));
                j++;
                maxlen=Math.max(maxlen,list.size());
            }
         else{
               list.remove(Character.valueOf(S.charAt(i)));
                i++;
         }
      }
        return maxlen;
    }
}