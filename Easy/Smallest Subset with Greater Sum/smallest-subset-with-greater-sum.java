//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.Collections;


class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t > 0){
            int N = sc.nextInt();
            int[] Arr = new int[N];
            for (int i = 0; i < N; ++i){
                Arr[i] = sc.nextInt();
            }
            Solution ob = new Solution();
            int ans = ob.minSubset(Arr,N);
            System.out.println(ans);
            t--;
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution { 

    int minSubset(int[] Arr,int N) { 
    //     Arrays.sort(Arr);
    //     int sum = 0;
    //  for(int i = 0;i<Arr.length;i++){
    //      sum = sum+Arr[i];
    //  }
    //  int count = 0;
    //  int val = 0;
    //  for(int i = N-1;i>=0;i--){
    //      if(val>sum){
    //          break;
    //      }else{
    //          val = val+Arr[i];
    //          sum = sum-Arr[i];
    //          count++;
    //      }
    //  }
    //  return count;
    
         long sum = 0;
        for(int i=0; i<N; i++){
            sum = sum + (long)Arr[i];
        }
        Arrays.sort(Arr);
        long outsideSum = 0;
        for(int i=N-1; i>=0; i--){
            outsideSum = outsideSum + (long)Arr[i];
            sum = sum - (long)Arr[i];
            if(sum<outsideSum){
                return N-i; 
            }
        }
        return N;
    }
}