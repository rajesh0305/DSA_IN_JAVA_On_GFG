//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {

        // taking input using Scanner class
        Scanner sc = new Scanner(System.in);

        // taking total testcases
        int t = sc.nextInt();
        while (t > 0) {

            // taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];

            // inserting elements in the array
            for (int i = 0; i < n; ++i) {
                array[i] = sc.nextInt();
            }

            // creating an object of class Solution
            Solution ob = new Solution();

            // calling longestSubsequence() method of class
            // Solution
            System.out.println(ob.longestSubsequence(n, array));
            t--;
        }
    }
}
// } Driver Code Ends




class Solution {
        static int recursive_lower_bound(int array[], int low,int high, int key) {
        // Base Case
        if (low > high) {
            return low;
        }
      // Find the middle index
        int mid = low + (high - low) / 2;
 
        // If key is lesser than or equal to
        // array[mid] , then search
        // in left subarray
        if (key <= array[mid]) {
 
            return recursive_lower_bound(array, low,mid - 1, key);
        }
 
        // If key is greater than array[mid],
        // then find in right subarray
        return recursive_lower_bound(array, mid + 1, high,
                                     key);
    }
    // Function to find length of longest increasing subsequence.
    static int longestSubsequence(int n, int a[]) {
        // code here
           ArrayList<Integer> temp = new ArrayList<>();
        int ans=1;
        temp.add(a[0]);
        for(int i=1;i<n;i++){
            if(a[i]>temp.get(temp.size()-1)){
                temp.add(a[i]);
                ans++;
            }
            else{
                int index = Collections.binarySearch(temp,a[i]);
                if(index<0){
                    index=-index-1;
                }
                temp.set(index,a[i]);
            }
        }
        return ans;
    }
}