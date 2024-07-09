//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int Arr[]= new int[N];
            for(int i = 0; i < N; i++)
                Arr[i] = Integer.parseInt(input_line[i]);
            int X = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.closest3Sum(Arr, N, X));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int closest3Sum(int A[], int N, int X)
    {
        // code here
        int n = N;
        Arrays.sort(A);
        int closestSum = A[0]+A[1]+A[2];
        for(int i =0;i<n-2;i++){
            int left  = i+1;
            int right = n-1;
            while(left<right){
                int currSum =A[i]+A[left]+A[right];
                if(Math.abs(X-closestSum)>Math.abs(X-currSum)){
                    closestSum = currSum;
                }
                if(currSum<X){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return closestSum;
            
    }
}