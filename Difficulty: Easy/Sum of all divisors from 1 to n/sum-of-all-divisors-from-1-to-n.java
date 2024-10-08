//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
            Solution ob = new Solution();
            long ans  = ob.sumOfDivisors(N);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    public static long div(int n){
        long sum = 0;
        if(n==1){
            return 1;
        }
        for(int i = 1;i<=n;i++){
            if(n%i==0){
                sum =sum+i;
            }
        }
        return sum;
    }
    static long sumOfDivisors(int N){
        // code here
        // long sum = 0;
        // for(int i = 1;i<=N;i++){
        //     sum = sum+div(i);
        // }
        // return sum;
        
        long ans  = 0;
        for(int i = 1;i<=N;i++){
            ans = ans+(N/i)*i;
        }
        return ans;
    }
}