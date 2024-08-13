//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;


// } Driver Code Ends
//User function template for JAVA

class Solution
{
    //Function to find the minimum indexed character.
    public static int minIndexChar(String str, String patt)
    {
        // Your code here
    //  int minIndex =Integer.MAX_VALUE;
    //  for(int i =0;i<patt.length();i++){
    //      for(int j= 0;j<str.length();j++){
    //          if(str.charAt(j)==patt.charAt(i)){
    //              minIndex = Math.min(minIndex,j);
    //              break;
    //          }
    //      }
    //  }
    //   return (minIndex==Integer.MAX_VALUE)?-1:minIndex;
    HashMap<Character,Integer>mp = new HashMap<>();
       for(int i =0;i<str.length();i++){
           if(!mp.containsKey(str.charAt(i))){
               mp.put(str.charAt(i),i);
           }
       }
       int minIndex =Integer.MAX_VALUE;
       for(int i = 0;i<patt.length();i++){
           if(mp.containsKey(patt.charAt(i))){
               minIndex = Math.min(minIndex,mp.get(patt.charAt(i)));
           }
       }
       return (minIndex==Integer.MAX_VALUE)?-1:minIndex;
    }
}

//{ Driver Code Starts.

class GFG {
	public static void main (String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t>0)
		{
		    t--;
		    
		    String s1=sc.next();
		    String s2=sc.next();
		    
		    int res = new Solution().minIndexChar(s1, s2);
		    System.out.println(res);
		}
	}
}

// } Driver Code Ends