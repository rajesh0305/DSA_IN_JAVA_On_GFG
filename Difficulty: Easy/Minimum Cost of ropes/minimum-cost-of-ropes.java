//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Number of test cases

        while (t-- > 0) {
            String[] input = br.readLine().split(" ");
            long[] a = new long[input.length];

            for (int i = 0; i < input.length; i++) {
                a[i] = Long.parseLong(input[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.minCost(a));
        }
    }
}

// } Driver Code Ends


//Back-end complete function Template for Java
class Solution {
    public static long optimal(long arr[]){
        int n=arr.length;
        PriorityQueue<Long> pq=new PriorityQueue<>();
        for(int i=0;i<n;i++){
            pq.add(arr[i]);
            
        }
        long ans=0;
        while(pq.size()>1){
            long fa=pq.remove()+pq.remove();
            ans+=fa;
            pq.add(fa);
        }
        return ans;
    }
    // Function to return the minimum cost of connecting the ropes.
    public long minCost(long[] arr) {
        // code here
        // Arrays.sort(arr);
        // ArrayList<Long>ans = new ArrayList<Long>();
        // for(int i =1;i<arr.length;i++){
        //     long  ele1 = arr[i];
        //     long ele2 = arr[i-1];
        //      long  ele3 = ele1+ele2;
        //     ans.add(ele3);
        //     arr[i] = ele3;
        //     Arrays.sort(arr);
        // }
        // long sum = 0;
        // for(int i = 0;i<ans.size();i++){
        //     sum =sum+ans.get(i);
        // }
        // return sum;
        return optimal(arr);
    }
}