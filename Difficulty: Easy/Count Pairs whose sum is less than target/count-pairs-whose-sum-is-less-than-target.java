//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java
class Solution {
    int countPairs(int arr[], int target) {
        // Your code here
          int n=arr.length;
        int c=0;
        Arrays.sort(arr);
        int j=0;
        for(int k=n-1;k>=0;k--)
        {
            if(arr[k]<target)
            {
                j=k;
                break;
            }
        }
        int i=0;
        while(i<j)
        {
            if(arr[i]+arr[j] < target) 
            {
                c+= (j - i);
                i++;
            }
            else j--;
        }
        // for(int i=0;i<n;i++)
        // {
        //     for(int j=i+1;j<n;j++)
        //     {
        //         if(arr[i]+arr[j] < target) c++;
        //     }
        // }
        // return c;
        return c;
    }
}

//{ Driver Code Starts.

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String line = read.readLine().trim();
            String[] numsStr = line.split(" ");
            int[] nums = new int[numsStr.length];
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int target = Integer.parseInt(read.readLine());

            Solution obj = new Solution();

            System.out.println(obj.countPairs(nums, target));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends