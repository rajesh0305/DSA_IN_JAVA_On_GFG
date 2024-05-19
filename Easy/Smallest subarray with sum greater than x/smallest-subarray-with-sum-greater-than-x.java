//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            int n = Integer.parseInt(stt.nextToken());
            int m = Integer.parseInt(stt.nextToken());
            // int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.smallestSubWithSum(a, n, m));
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution {

    public static int smallestSubWithSum(int a[], int n, int x) {
        // Your code goes here 
        // Approach  1-->O(N^2)
    //  int prevLength = Integer.MAX_VALUE;
    //  for(int i = 0;i<a.length;i++){
    //      int sum =0;
    //      for(int j = i;j<a.length;j++){
    //          sum = sum+a[j];
    //          if(sum>x){
    //              prevLength = Math.min(prevLength,j-i+1);
    //          }
    //      }
    //  }
    //  if(prevLength==Integer.MAX_VALUE){
    //      return 0;
    //  }
    //  return prevLength;
    
    int windowStart =0;
    int windowEnd = 0;
    int sum= 0;
    int length = Integer.MAX_VALUE;
    while(windowEnd<n){
        sum = sum+a[windowEnd];
        if(sum>x){
            length  = Math.min(length,windowEnd-windowStart+1);
            while(sum>x && windowStart<=windowEnd){
                sum -=a[windowStart];
                length = Math.min(length,windowEnd-windowStart+1);
                 windowStart++;
             }
        }
        windowEnd++;
    }
    // if(length==Integer.MAX_VALUE){
    //     return 0;
    // }
return (length==Integer.MAX_VALUE)?0:length;
    }
}

