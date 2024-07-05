//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(a[i]);
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.nextPermutation(N, arr);
            StringBuilder out = new StringBuilder();
            for(int i = 0;i < N;i++)
                out.append(ans.get(i) + " ");
            System.out.println(out);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    // public class Node{
    //     public int val;
    //     public Node next;
        
    //     public Node(int val){
    //         this.val = val;
            
    //     }
    // }
    // public static int[] reverse(int arr[],int n){
    //     int ans[] = new int [arr.length];
    //     int k = 0;
    //     for(int i  =n-1;i>=0;i--){
    //         ans[k++] = arr[i];
    //     }
    //     return ans;
    // }
    // public static List<Integer> Makelist(int arr){
    //     Node head = new Node(arr[0]);
    //     Node temp = head;
    //     for(int i =1;i<arr.length;i++){
    //         Node newnode = new Node(arr[i]);
    //         temp.next=newnode;
    //         temp = temp.next;
    //     }
    //     return head;
    // }
    static List<Integer> nextPermutation(int N, int arr[]){
        // code here
        // int index =-1;
        // for(int i =N-2;i>=0;i--){
        //     if(arr[i]<arr[i+1]){
        //         index = i;
        //         break;
        //     }
        // }
        // if(index ==-1){
        //   reverse(arr,N);
        //   return Makelist(arr);
        // }
        // for(int i =N-1;i>=index;i--){
        //     if(arr[i]>arr[index]){
        //         int temp = arr[i];
        //         arr[i] = arr[index];
        //         arr[index] = temp;
        //         break;
        //     }
        // }
        // reverse(arr,index+1);
        // return Makelist(arr);
     List<Integer> res = new ArrayList<>();   
        
        int ind =-1;
        int n = arr.length;
        
        for( int i = n-2 ; i >= 0 ; i--){
            if( arr[i] < arr[i+1] ){
                ind = i;
                break;
            }
        }
        if( ind == -1 ) {
        reverse( arr , 0 , n-1);
        }else{
            for ( int i= n-1 ; i > ind ; i--){
                if( arr[i] > arr[ind]){
                    swap( arr, i , ind);
                    break;
                }
            }
            
        reverse( arr, ind+1 , n-1);
        }
        for( int i=0 ; i < n ; i++){
            res.add( arr[i]);
        }
        return res;
        
    }
    
    public static void swap( int[] arr, int st, int end) {
        int temp = arr[st];
        arr[st] = arr[end];
        arr[end] = temp;
    }

    public static void reverse( int[] arr, int st, int end) {
        while (st < end) {
            int temp = arr[st];
            arr[st] = arr[end];
            arr[end] = temp;
            st++;
            end--;
        }
    }
}