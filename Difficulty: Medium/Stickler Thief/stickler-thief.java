//{ Driver Code Starts
import java.util.*;
import java.io.*;

class GFG
 {
	public static void main (String[] args)
	 {
	  
	  //taking input using Scanner class
	  Scanner sc = new Scanner(System.in);
	  
	  //taking count of testcases
	  int t = sc.nextInt();
	  while(t-- > 0){
	      
	      //taking count of houses
	      int n = sc.nextInt();
	      int arr[] = new int[n];
	      
	      //inserting money present in 
	      //each house in the array
	      for(int i = 0; i<n; ++i)
	           arr[i] = sc.nextInt();
  	      
  	      //calling method FindMaxSum() of class solve
  	      System.out.println(new Solution().FindMaxSum(arr, n));
	 }
   }
}
// } Driver Code Ends


class Solution
{
    public static int find(ArrayList<Integer>arr){
        int sum = 0;
        for(int i = 0;i<arr.size();i++){
            sum = sum+arr.get(i);
        }
        return sum;
        
    }
     public static int solution(int arr[]){
       int prev = arr[0];
       int prev_of_prev = 0;
       int max =prev;
       for(int i = 1;i<arr.length;i++){
           max = Math.max(max,prev_of_prev+arr[i]);
           prev_of_prev =prev;
          prev =max;
       }
       return max;
     }
    //Function to find the maximum money the thief can get.
    public int FindMaxSum(int arr[], int n)
    {
        // Your code here
        ArrayList<Integer>even = new  ArrayList<Integer>();
        ArrayList<Integer>odd = new ArrayList<Integer>();
      for(int i = 0;i<n;i++){
          if(i%2==0){
              even.add(arr[i]);
          }else{
              odd.add(arr[i]);
          }
      }
      int evensum = find(even);
      int oddsum =find(odd);
      return solution(arr);
    }
}