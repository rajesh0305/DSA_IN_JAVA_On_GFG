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
            String s = br.readLine();
            String[] S = s.split(" ");
            int[] v = new int[2 * n + 2];
            for(int i = 0; i < 2 * n + 2; i++)
            {
                v[i] = Integer.parseInt(S[i]);
            }
            Solution ob = new Solution();
            int[] ans = ob.singleNumber(v);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int[] singleNumber(int[] nums)
    {
        // Code here
        // int xor = 0;
        // int ele1 = 0;
        // int ele2 = 0;
        // int ans[] = new int [2];
        // for(int i = 0;i<nums.length;i++){
        //     xor = xor^nums[i];
            
        // }
        // int rmb = xor&(~(xor-1));
        // for(int i = 0;i<nums.length;i++){
        //     if((nums[i]&rmb)!=0)
        //         ele1^=nums[i];
        //     else
        //         ele2^=nums[i];
        // }
        // if(ele1<ele2){
        //     ans[0] = ele1;
        // }else{
        //     ans[1] = ele2;
        // }
        // return ans;
         int xori= 0;
        for(int i=0;i<nums.length;i++){
            xori^=nums[i];
        }
        
        xori=xori&(-xori);
        int ans[] = new int [2];
        for(int i=0;i<nums.length;i++){
            if((nums[i]&xori)!=0){
                ans[1]^=nums[i];
            }
            else{
                ans[0]^=nums[i];
            }
        }
        if(ans[0]>ans[1]){
            int temp = ans[0];
            ans[0] = ans[1];
            ans[1] = temp;
        }
        
        return ans;
    }
}