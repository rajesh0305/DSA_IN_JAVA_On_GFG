//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution{
        public static int checkBit(int pat, int a[], int n){
        int c=0;
        for(int i=0; i<n; i++){
            if((pat & a[i]) == pat) c++;
        }
        return c;
    }
   // Function for finding maximum AND value.
    public static int maxAND (int arr[], int N) {
        
        // Your code here
        // You can add extra function (if required)
    //     if(N==1){
    //         return 0;
    //     }
    //     int max = Integer.MIN_VALUE;
    //   for(int i =0;i<N;i++){
    //       for(int j  = i+1;j<N;j++){
    //           int val = arr[i]&arr[j];
    //           max = Math.max(max,val);
    //       }
    //   }
    //   return max;
         int res=0;
        int count;
        for(int i=31; i>=0; i--){
            count = checkBit((res|(1<<i)),arr,N);
            if(count>=2){
                res |= (1<<i);
            }
        }
        return res;
    }
    
}

//{ Driver Code Starts.

class BitWise {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    
		    //input size of array
		    int n = Integer.parseInt(br.readLine());
		    String inputLine[] = br.readLine().trim().split(" ");
		    int arr[] = new int[n];
		    
		    //inserting elements in the array
		    for(int i=0; i<n; i++){
		        arr[i]=Integer.parseInt(inputLine[i]);
		    }
		    
		    Solution obj = new Solution();
		    
		    //calling maxAND() method of class AND
		    System.out.println(obj.maxAND(arr, n));
		}
	}
}

// } Driver Code Ends