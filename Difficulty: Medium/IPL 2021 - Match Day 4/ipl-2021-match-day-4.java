//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class AND{
    
   // Function for finding maximum AND value.
    public static int maxAND (int arr[], int n) {
        
        // Your code here
        // You can add extra function (if required)
           int ans=0;
        for(int i=31;i>=0;i--){
            int curr=(ans|1<<i);
            int cnt=0;
            for(int j=0;j<n;j++){
                if((curr&arr[j])==curr){
                    cnt++;
                }
                if(cnt>=2){
                    ans=curr;
                    break;
                }
            }
        }
        return ans;
        
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
		    
		    AND obj = new AND();
		    
		    //calling maxAND() method of class AND
		    System.out.println(obj.maxAND(arr, n));
		}
	}
}

// } Driver Code Ends