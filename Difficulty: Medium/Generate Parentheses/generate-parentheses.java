//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = Integer.parseInt(sc.next());
        while(t>0)
        {
            int n = Integer.parseInt(sc.next());
            Solution T = new Solution();
            List<String> ans = T.AllParenthesis(n);
            String[] sequences = ans.toArray(new String[0]);
            Arrays.sort(sequences);
            int k = sequences.length;
            for(int i=0;i<k;i++)
            {
                System.out.println(sequences[i]);
            }
            
            t--;
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    
   public List<String> AllParenthesis(int n) 
    {
        List<String> ans=new ArrayList<>();
        StringBuilder st=new StringBuilder();
        find(0,0,n,ans,st);
        return ans;
    }
    
    public void find(int open,int close,int n,List<String> ans,StringBuilder st){
        
        if(st.length()==2*n){
            ans.add(st.toString());
            return;
        }
        
        if(open<n){
            st.append('(');
            find(open+1,close,n,ans,st);
            st.deleteCharAt(st.length()-1);
        }
        
        if(close<open){
            st.append(')');
            find(open,close+1,n,ans,st);
            st.deleteCharAt(st.length()-1);
        }
    }
}