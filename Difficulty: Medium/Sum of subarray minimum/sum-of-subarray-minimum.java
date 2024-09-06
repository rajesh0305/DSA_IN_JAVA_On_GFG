//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
class Solution {
    public static int findmin(ArrayList<Integer>arr){
        int min =Integer.MAX_VALUE;
        for(int i = 0;i<arr.size();i++){
            if(arr.get(i)<min){
                min = arr.get(i);
            }
        }
        return min;
    }
    public static int minsubarraysum(int arr[]){
           int mod =100000000+7;
        ArrayList<Integer>ans = new ArrayList<Integer>();
        for(int i = 0;i<arr.length;i++){
            for(int j = i;j<arr.length;j++){
                ArrayList<Integer>inter = new ArrayList<Integer>();
                for(int k =i;k<=j;k++){
                    inter.add(arr[k]);
                }
               ans.add(findmin(inter)); 
            }
        }
        int sum = 0;
        for(int i =0;i<ans.size();i++){
            sum = sum+ans.get(i);
        }
        return sum%mod;
    }
    public static int sumSubarrayMins(int[] arr) {
        // code here
         int mod = 1000000000+7;
         int sum = 0;
         for(int i =0;i<arr.length;i++){
             int min =arr[i];
             for(int j = i;j<arr.length;j++){
                 min = Math.min(min,arr[j]);
                 sum = sum+min;
                // sum = sum%mod;
             }
         }
         return sum%mod;
    }
}


//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
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
            Solution obj = new Solution();
            int res = obj.sumSubarrayMins(arr);

            System.out.println(res);

            // System.out.println("~");
        }
    }
}

// } Driver Code Ends