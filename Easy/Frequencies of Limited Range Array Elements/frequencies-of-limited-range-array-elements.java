//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
        int t = Integer.parseInt(br.readLine().trim()); 
        while(t-->0){
            
            //size of array
            int N = Integer.parseInt(br.readLine().trim()); 
            int arr[] = new int[N];
            String inputLine[] = br.readLine().trim().split(" ");

            //adding elements to the array
            for(int i = 0 ; i < N; i++){
                arr[i]=Integer.parseInt(inputLine[i]); 
            }
            int P= Integer.parseInt(br.readLine().trim());
            //calling frequncycount() function
            Solution ob = new Solution();
            ob.frequencyCount(arr, N, P); 
            
            //printing array elements
            for(int i = 0; i < N ; i++)
                System.out.print(arr[i] + " " );
            System.out.println();
        }
    }
}




// } Driver Code Ends


class Solution{
    //Function to count the frequency of all elements from 1 to N in the array.
    public static int freq(int arr[],int ele){
        int count  = 0;
        for(int i = 0;i<arr.length;i++){
            if(ele ==arr[i]){
                count++;
            }
        }
        return count;
    }
    public static void frequencyCount(int arr[], int N, int P)
    {
    //     // code here
    // Approach 1--->O(N^2)
    
    //     int ans[] = new int [N];
    //  for(int i = 0;i<arr.length;i++){
    //      if(arr[i]>N){
    //          continue;
    //      }
    //      int ele = arr[i];
    //      int count = freq(arr,ele);
    //      ans[ele-1] = count;
    //  }
    //  for(int i =0;i<N;i++){
    //      arr[i] =ans[i];
    //  }
    
    // Approach 2--->O(N)+O(N)=>O(N)
    
        int ans[] = new int [N];
        for(int i = 0;i<N;i++){
            if(arr[i]>N){
                continue;
            }
            ans[arr[i]-1]++;
        }
        for(int i =0;i<N;i++){
            arr[i] =ans[i];
        }
    }
}
