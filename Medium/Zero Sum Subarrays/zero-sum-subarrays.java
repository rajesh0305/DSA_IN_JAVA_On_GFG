//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		sc.nextLine();
		while(t-->0)
		{
		    int n;
		    n=sc.nextInt();
		    
		    long arr[]=new long[n];
	
		    
		    for(int i=0;i<n;i++)
		    {
		        arr[i]=sc.nextLong();
		    }
            Solution ob = new Solution();
		    System.out.println(ob.findSubarray(arr,n));
		}
		
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    //Function to count subarrays with sum equal to 0.
    public static long findSubarray(long[] arr ,int n) 
    {
        //Your code here
        // approach 1--->O(N^3)
        
        // long count = 0;
        // for(int i = 0;i<arr.length;i++){
        //       long sum = 0;
        //     for(int j = i;j<arr.length;j++){
        //           for(int k = i;k<=j;k++){
        //               sum = sum+arr[k];
                     
        //           }
        //           if(sum==0){
        //               count++;
        //           }
        //     }
        // }
        
        // //Approach 2-->O(n^2)
        // long count  = 0;
        // for(int i = 0;i<arr.length;i++){
        //     long sum = 0;
        //     for (int j = i;j<arr.length;j++){
        //         sum = sum+arr[j];
        //         if (sum==0)
        //           count = count+1;
        //     }
        // }
        // return count;
        
        // Approach 3 ---->O(N) time complexity
        //                 O(N) space complexity
        
        int count = 0;
        HashMap<Integer,Integer>map = new HashMap<Integer,Integer>();
        map.put(0,1);
        int  prevsum=0;
        int k = 0;
        for(int i =0;i<arr.length;i++){
            prevsum +=arr[i];
             if(map.containsKey(prevsum)){
                 count = count+map.get(prevsum);
                 map.put(prevsum,map.get(prevsum)+1);
             }else{
                 map.put(prevsum,1);
             }
            
        }
        return count;
    }
}