//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input1 = sc.nextLine();
            Scanner ss1 = new Scanner(input1);
            while (ss1.hasNextInt()) {
                arr.add(ss1.nextInt());
            }
            Solution ob = new Solution();
            int res = ob.findKRotation(arr);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int bs(List<Integer>arr){
        int minindex = 0;
        int min = Integer.MAX_VALUE;
        for(int i =0;i<arr.size();i++){
            if(arr.get(i)<min){
                min =arr.get(i);
                minindex = i;
            }
        }
        return minindex;
    }
    public int findKRotation(List<Integer> arr) {
        // Code here
        int index = bs(arr);
        return index ;
    }
}