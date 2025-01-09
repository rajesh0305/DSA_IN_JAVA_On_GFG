//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim());

        while (t-- > 0) {
            String line = read.readLine().trim();
            String[] numsStr = line.split(" ");
            int[] nums = new int[numsStr.length];
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int d = Integer.parseInt(read.readLine().trim());

            Solution ob = new Solution();
            ArrayList<Integer> result = ob.subarraySum(nums, d);
            // Print all elements in the result list
            for (int i : result) {
                System.out.print(i + " ");
            }
            System.out.println(); // Print a new line after the result
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        // code here
         ArrayList<Integer> res = new ArrayList<>();
        res.add(-1);
        for(int i = 0; i < arr.length ; i++){
            int sum=arr[i];
            if (arr[i] == target){
                res.set(0,i+1);
                res.add(i+1);
                return res;
            }
            for(int j = i+1; j < arr.length ; j++){
                sum+=arr[j];
                if(sum == target){
                    res.set(0,i+1);
                    res.add(j+1);
                    return res;
                }
                else if(sum>target) break;
    
            }
        }
        return res ;
    }
}
