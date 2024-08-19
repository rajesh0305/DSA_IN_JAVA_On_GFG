//{ Driver Code Starts
// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String line = in.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int key = Integer.parseInt(in.readLine().trim());
            Solution ob = new Solution();
            out.println(ob.kthSmallest(arr, key));
        }
        out.flush();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static void findmin(int arr[]){
        int minindex = 0;
        int min =Integer.MAX_VALUE;
        for(int i = 0;i<arr.length;i++){
            if(arr[i]<min){
                min = arr[i];
                minindex = i;
            }
        }
        arr[minindex] = Integer.MAX_VALUE;
    }
    public static int kthSmallest(int[] arr, int k) {
        // Your code here
        // for(int i = 0;i<k-1;i++){
        //     findmin(arr);
        // }
        // int min =Integer.MAX_VALUE;
        // for(int i= 0;i<arr.length;i++){
        //     if(arr[i]<min){
        //         min = arr[i];
        //     }
        // }
        // return min;
           PriorityQueue<Integer> prio = new PriorityQueue<>();
        for(int i = 0; i < arr.length; i++){
             prio.add(arr[i]);
        }
        for(int i = 1; i < k; i++){
            prio.poll();
        }
        return prio.peek();
    }
}
