//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            String[] nk = br.readLine().trim().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            Solution sln = new Solution();
            ArrayList<ArrayList<Integer>> ans = sln.fourSum(a, k);
            for (ArrayList<Integer> v : ans) {
                for (int u : v) {
                    System.out.print(u + " ");
                }
                System.out.print("$");
            }
            if (ans.isEmpty()) {
                System.out.print(-1);
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// arr[] : int input array of integers
// k : the quadruple sum required

class Solution {
    public static int BS(int arr[],int low,int high,int x){
        int index = -1;
        while(low<high){
            int mid = low+(high-low)/2;
            if(arr[mid]==x){
                return mid;
            }
            // If x greater, ignore left half
            if (arr[mid] < x)
                low = mid + 1;

            // If x is smaller, ignore right half
            else
                high = mid - 1;
        }
        return -1;
    }
    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
        // code here
    Arrays.sort(arr);
        Set<ArrayList<Integer>> res = new LinkedHashSet<>();
        for (int i = 0;i<arr.length-3;i++){
            for (int j = i+1;j<arr.length-2;j++){
                int l = j+1;
                int r = arr.length-1;
                int curSum = arr[i]+arr[j] ; 
                while (l<r){
                    int sum = curSum + arr[l] + arr[r];
                    if (sum==k){
                        ArrayList <Integer> al = new ArrayList<>();
                        al.add(arr[i]);
                        al.add(arr[j]);
                        al.add(arr[l]);
                        al.add(arr[r]);
                        res.add(al);
                        l++;
                        r--;
                    }
                    else if (sum>k)
                        r--;
                    else
                        l++;
                }
            }
        }
        return new ArrayList<>(res);
    }
}