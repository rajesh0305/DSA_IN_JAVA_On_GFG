//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());
        
        while(t-- > 0)
        {
            String s[]=in.readLine().trim().split(" ");
            String a = s[0];
            String b = s[1];
            Solution g = new Solution();
            if(g.isScramble(a,b)){
                out.println("Yes");
            }
            else{
                out.println("No");
            }
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static boolean isScramble(String S1,String S2)
    {
        //code here
        if(S1.length()!=S2.length())   // If both length not same
        return false;
        
        if(S1.length()==0&&S2.length()==0)  // if both empty
        return true;
        
        
        HashMap<String,Boolean> map=new HashMap<String,Boolean>();  // For storing result
        
        return solve(S1,S2,map);
    }
    
    public static boolean solve(String str1 , String str2, HashMap<String,Boolean> map){
        
        if(str1.equals(str2))   // Both string same 
        return true;
        
        if(str1.length()<=1||str2.length()<=1){   // if any one string length one and if not same that means , both string different length then return false
            return false;
        }
        
        
        
        String key=str1+" "+str2;
        
        if(map.containsKey(key))
        return map.get(key);
        
        boolean flag=false;
        
        for(int i=1;i<str1.length();i++){                   // both string same length
           boolean cond1= solve(str1.substring(0, i),str2.substring(str2.length()-i),map) && solve(str1.substring(i), str2.substring(0, str2.length()-i),map);  // if swaping done
           boolean cond2= solve(str1.substring(0, i),str2.substring(0, i),map) && solve(str1.substring(i), str2.substring(i),map);  // if swaping not done
            if(cond1 || cond2){
                flag=true;  // if scrambled than break
                break;
            }
        }
        
        map.put(key,flag);
        return map.get(key);
    }
}
