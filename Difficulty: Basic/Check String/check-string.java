//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String s = sc.next ();
            if (new Sol().check (s))
                System.out.println ("YES");
            else
                System.out.println ("NO");
        }
        
    }
}
// Contributed By: Pranay Bansal

// } Driver Code Ends


//User function Template for Java

class Sol
{
    Boolean check (String s)
    {
        // your code here  
         int n=s.length();
        if(n==1)return true;
        if(n==2&& s.charAt(0)==s.charAt(1))return true;
        for(int i=0;i<n;i++){
            if(s.charAt(i)==s.charAt(i+1)){
               
                if(i==n-2){//last before index
                    if(s.charAt(i)==s.charAt(n-1)){
                        break;
                    }
                }
                 continue;
            }
            else{
                return false;
            }
        }
        return true;
    }
}