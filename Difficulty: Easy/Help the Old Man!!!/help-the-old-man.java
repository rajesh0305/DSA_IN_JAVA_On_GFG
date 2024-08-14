//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(a[0]);
            int n = Integer.parseInt(a[1]);
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.shiftPile(N, n);
            System.out.println(ans.get(0)+" "+ans.get(1));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Count{
    int count = 0;
}

class Solution{
    static List<Integer> shiftPile(int N, int n){
        List<Integer> list = new ArrayList<>();
        traverse(list, N, n, 1, 3, 2, new Count());
        return list;
    }
    
    static void traverse(List<Integer> list, 
            int N, int n, int from, int to, int aux, Count c){
        if(N>0){
            traverse(list, N-1, n, from, aux, to, c);
            c.count+=1;
            if(c.count==n){
                list.add(from);
                list.add(to);
            }
            traverse(list, N-1, n, aux, to, from, c);
        }
    }
}