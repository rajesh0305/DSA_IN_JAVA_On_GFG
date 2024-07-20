//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            int k = Integer.parseInt(br.readLine().trim());
            
            Compute obj = new Compute();
            long answer[] = obj.printFirstNegativeInteger(a, n, k);
            int sz = answer.length;
            
            StringBuilder output = new StringBuilder();
            for(int i=0;i<sz;i++)
                output.append(answer[i]+" ");
            System.out.println(output);
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Compute {
    public static long checkN(long arr[],int start,int end){
        for(int i = start;i<=end;i++){
            long ele = arr[i];
            if(ele<0){
                return ele;
            }
        }
        return 0;
    }
    public long[] printFirstNegativeInteger(long A[], int N, int K)
    {
        ArrayList<Long>ans = new ArrayList<Long>();
        int n = A.length;
        int k = K;
        long dumm = 0;
        for(int i= 0;i<n-k+1;i++){
            long ele= checkN(A,i,i+k-1);
            if(ele<0){
                ans.add(ele);
            }else{
                ans.add(dumm);
            }
        }
        long res[] = new long[ans.size()];
        for(int i = 0;i<ans.size();i++){
            res[i] = ans.get(i);
        }
        return res;
    }
}