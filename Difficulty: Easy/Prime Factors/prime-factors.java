//{ Driver Code Starts


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
            int N = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int[] ans = ob.AllPrimeFactors(N);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends




class Solution
{
    public static int[] better(int n){
        ArrayList<Integer>ans = new ArrayList<Integer>();
        for(int i = 2;i<=n;i++){
            if(n%i==0){
                ans.add(i);
                while(n%i==0){
                    n = n/i;
                }
            }
        }
        int res[] = new int [ans.size()];
        for(int i = 0;i<ans.size();i++){
            res[i] = ans.get(i);
        }
        return res;
    }
    public static int [] optimal(int n){
        ArrayList<Integer>ans = new ArrayList<Integer>();
        for(int i = 2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                ans.add(i);
                while(n%i==0){
                    n = n/i;
                }
            }
        }
        if(n!=1){
            ans.add(n);
        }
        int res[] = new int [ans.size()];
        for(int i = 0;i<ans.size();i++){
            res[i] = ans.get(i);
        }
        return res;
    }
    public int[] AllPrimeFactors(int N)
    {
        // code here
       // return better(N);
      return  optimal(N);
    }
}