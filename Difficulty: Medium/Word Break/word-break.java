//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
public class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n;
                    n = sc.nextInt();
                    ArrayList<String> dictionary = new ArrayList<String>();
                    for(int i = 0;i<n;i++)
                        {
                            String p = sc.next();
                            dictionary.add(p);
                        }
                    String s = sc.next();
                    Solution obj = new Solution();  
                    System.out.println(obj.wordBreak(n, s, dictionary));  
                    
                }
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static int wordbreak(int n,String s,ArrayList<String>dictionary){
              int dp[] = new int [s.length()];
        for(int i = 0;i<dp.length;i++){
            for(int j = 0;j<=i;j++){
                String word2check = s.substring(j,i+1);
                if(dictionary.contains(word2check)){
                    if(j>0){
                        dp[i] = dp[i]+dp[j-1];
                    }else{
                        dp[i] = dp[i]+1;
                    }
                }
            }
        }
        return (dp[s.length()-1]>0==true)?1:0;
    }
    public static int wordBreak(int n, String s, ArrayList<String> dictionary )
    {
        //code here
     HashSet<String> set = new HashSet<>();
        for(int i=0;i<dictionary.size();i++){
            set.add(dictionary.get(i));
        }
        boolean dp[] = new boolean[s.length()+1];
        boolean ans = isPossible(s,set,dp,0);
        if(ans){
            return 1;
        }else{
            return 0;
        }
    }
    public static boolean isPossible(String s,HashSet<String> set,boolean dp[],int pos){
        
        if(pos==s.length()){
            return true;
        }
        
        if(dp[pos]!=false){
            return dp[pos];
        }
        
        String temp = "";
        for(int i=pos;i<s.length();i++){
            temp += s.charAt(i);
            if(set.contains(temp)){//if dictionary contain temp then check for next
                if(isPossible(s,set,dp,i+1)){
                    return dp[i] = true;
                }
            }
        }
        return dp[pos];
    }
}