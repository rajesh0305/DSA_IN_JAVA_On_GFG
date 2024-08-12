//{ Driver Code Starts
// Initial Template for Java

import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    public int SumofMiddleElements(int[] arr1, int[] arr2) {
        // code here
          // code here
        int n1 = arr1.length;
        int n2 = arr2.length;
        int size = n1+n2;
        int ans[] = new int [size];
        int i = 0;
        int j = 0;
        int k = 0;
      while(i<n1 && j<n2){
          if(arr1[i]<=arr2[j]){
              ans[k++] = arr1[i];
              i++;
          }else{
              ans[k++] = arr2[j];
              j++;
          }
      }
      while(i<n1){
          ans[k++] = arr1[i];
          i++;
      }
      while(j<n2){
          ans[k++] = arr2[j];
          j++;
      }
      int low = 0;
      int re =0;
      int high = ans.length-1;
      int mid = low+(high-low)/2;
      if(ans.length%2==0){
          re = ans[mid]+ans[mid+1];
      }else{
          re = ans[mid];
      }
      return re;
    }
}

//{ Driver Code Starts.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume newline
        while (t-- > 0) {
            String[] input1 = sc.nextLine().split(" ");
            int[] arr = new int[input1.length];
            for (int i = 0; i < input1.length; i++) {
                arr[i] = Integer.parseInt(input1[i]);
            }

            String[] input2 = sc.nextLine().split(" ");
            int[] brr = new int[input2.length];
            for (int i = 0; i < input2.length; i++) {
                brr[i] = Integer.parseInt(input2[i]);
            }

            Solution ob = new Solution();
            int res = ob.SumofMiddleElements(arr, brr);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends