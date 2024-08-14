//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Recursion {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();//testcases
		while(T-->0)
		{
		    Solution obj=new Solution();
		    
		    int n,k;
		    //taking input n and k
		    n=sc.nextInt();
		    k=sc.nextInt();
		    
		    //calling josephus() function
		    System.out.println(obj.josephus(n,k));
		    
		    
		}
		
	}
}


// } Driver Code Ends


class Solution
{
   public int winner( int n, int k ) {
        if(n == 1) return  0  ; 
        
        int ans = (winner(n-1, k)+k )%n ; 
        return ans ; 
   }    
    
    public static int fun(ArrayList<Integer>ans,int start,int k){
        if(ans.size()==1){
            return ans.get(0);
        }
        start = ((start+k)%(ans.size()-1));
        ans.remove(start);
        return fun(ans,start,k);
    }
   public int josephus(int n, int k)
    {
   int won =  winner(n , k )+1; 
       return won; 
    }

}

