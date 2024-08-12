//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0){
			int n = sc.nextInt();
			int[][] a = new int[n][n];
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					a[i][j] = sc.nextInt();
			Solution T = new Solution();
			ArrayList<Integer> arr= T.mergeKArrays(a, n);
			for(int i = 0; i < n*n ; i++)
			    System.out.print(arr.get(i)+" ");
		    System.out.println();
		    
		    t--;
		}
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution
{
    public static void merge(ArrayList<Integer>arr1,int arr2[],ArrayList<Integer>ref){
        int n1 = arr1.size();
        int n2 = arr2.length;
        int i = 0;
        int j = 0;
    //    ArrayList<Integer>ans =new ArrayList<Integer>();
        while(i<n1 && j<n2){
            if(arr1.get(i)<=arr2[j]){
                ref.add(arr1.get(i));
                i++;
            }else{
                ref.add(arr2[j]);
                j++;
            }
        }
        while(i<n1){
            ref.add(arr1.get(i));
            i++;
        }
        while(j<n2){
            ref.add(arr2[j]);
            j++;
        }
        // for(int k = 0;k<ans.size();k++){
        //     arr1.add(ans.get(k));
        // }
    }
    //Function to merge k sorted arrays.
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int K) 
    {
        // Write your code here.
        // ArrayList<Integer>ans = new ArrayList<Integer>();
        // ArrayList<Integer>ref = new ArrayList<Integer>();
        // int row = arr.length;
        // for(int i = 0;i<row;i++){
        //       merge(ans,arr[i],ref);
        // }
        // return ref;
        PriorityQueue<Integer>pq = new PriorityQueue<Integer>();
        for(int i = 0;i<arr.length;i++){
           for(int j = 0;j<arr[0].length;j++){
               pq.add(arr[i][j]);
           } 
        }
        ArrayList<Integer>ans =new ArrayList<Integer>();
      while(!pq.isEmpty()){
          ans.add(pq.poll());
      }
        return ans;
    }
}