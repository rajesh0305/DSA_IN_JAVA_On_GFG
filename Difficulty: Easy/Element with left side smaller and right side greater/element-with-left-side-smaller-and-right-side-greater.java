//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            while (st.hasMoreTokens()) {
                arr.add(Integer.parseInt(st.nextToken()));
            }
            Solution ob = new Solution();
            int ans = ob.findElement(arr);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static boolean left(int ele,List<Integer>arr,int start,int end){
      for(int i =start;i<=end;i++){
          if(ele<arr.get(i)){
              return false;
          }
      }  
      return true;
    }
    public static boolean right(int ele,List<Integer>arr,int start,int end){
        for(int i = start;i<=end;i++){
            if(ele>arr.get(i)){
                return false;
            }
        }
        return true;
    }
    public int findElement(List<Integer> arr) {
        // Code here
           int n = arr.size();
      for (int i = 1; i < n - 1; i++) { // Ensure that i+1 is within bounds
        if (arr.get(i) > arr.get(i - 1) && arr.get(i) < arr.get(i + 1)) {
            boolean flag1 = true, flag2 = true;
            int j = i - 1;
            int k = i + 1;
            int a = arr.get(i);
            
            while (j >= 0) {  // Check elements to the left
                if (a <= arr.get(j)) {
                    flag1 = false;
                    break;
                }
                j--;
            }
            
            while (k < n) {  // Check elements to the right
                if (a >= arr.get(k)) {
                    flag2 = false;
                    break;
                }
                k++;
            }
            
            if (flag1 && flag2) {
                return arr.get(i);
            }
        }
    }
    return -1; 
    }
}