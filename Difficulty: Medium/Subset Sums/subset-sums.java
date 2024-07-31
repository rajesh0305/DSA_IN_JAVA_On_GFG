//{ Driver Code Starts

// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            ArrayList<Integer> arr = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                arr.add(sc.nextInt());
            }
            Solution ob = new Solution();

            ArrayList<Integer> ans = ob.subsetSums(arr, N);
            Collections.sort(ans);
            for (int sum : ans) {
                System.out.print(sum + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java//User function Template for Java
class Solution {
      public static void find(ArrayList<Integer> arr,ArrayList<Integer> ars,int i,int sum,int n){
        if(n==i){
            ars.add(sum);
            return;
        }
        // taken the element
        find(arr,ars,i+1,sum+arr.get(i),n);
        //not taken the element
        find(arr,ars,i+1,sum,n);
    }
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n) {
        // code here
        // ArrayList<Integer>ans= new ArrayList<Integer>();
        // for(int i=0;i<arr.size();i++){
        //     for(int j = i;j<arr.size();j++){
        //         int sum = 0;
        //         for(int k= 0;k<=j;j++){
        //          sum = sum+arr.get(i);   
        //         }
        //         ans.add(sum);
        //     }
        // }
        // return ans;
             ArrayList<Integer> ars=new ArrayList<Integer>();
        find(arr,ars,0,0,n);
        Collections.sort(ars);
        return ars;
    }
}