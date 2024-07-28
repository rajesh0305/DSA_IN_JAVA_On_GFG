//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int[] ans = ob.xor_play(n);
            for(int i = 0; i < ans.length - 1; i++)
            {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
            System.out.println(ans[ans.length - 1]);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int[] xor_play(int n)
    {
        // code here
      int arr[]=new int[1];
       if(n==1){
           arr[0]=0;
          return arr;
       }
       
        Set<Integer> set = new LinkedHashSet<Integer>();
       set.add(1);
       int temp=n;
       int i=0;
       
     for(i=2;((i!=n)&(i*i<n));i++){
          if(n%i==0)
             set.add(i);
      } 
      
       for(;((i!=n)&(i>1));i--){
          if(n%i==0)
             set.add(n/i);
       }  
      
       
     arr=new int[set.size()+1];
      int xor =0;
      int j=0;
      for(Integer ele:set){
            arr[j]= ele;
             xor = arr[j]^xor;
             
             j++;
      }
      
      arr[set.size()]=xor;
            
    return arr;  
    }
}