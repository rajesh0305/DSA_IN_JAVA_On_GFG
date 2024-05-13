//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main (String[] args)throws IOException
	{

// 		Scanner in = new Scanner(System.in);
        
// 		int t = in.nextInt();
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
         //testcases
        int t = Integer.parseInt(read.readLine());
		
		while(t-- >0)
		{
		    //size of array
		    int n = Integer.parseInt(read.readLine());
		    long[] arr= new long[n];
		    
		    String str[] = read.readLine().trim().split(" ");
		    
		    //adding elements to the array
		    for(int i=0;i<n;i++)
		        arr[i] = Long.parseLong(str[i]);
		    
		    // StringBuffer sb = new StringBuffer();
		    
		    Solution ob = new Solution();
		    
		    //calling rearrange() function
		    ob.rearrange(arr, n);
		    StringBuffer sb = new StringBuffer();
		    
		    //appending and printing the elements
		    for(int i =0; i < n; i++)
		     sb.append(arr[i] + " ");
		    System.out.println(sb);
		}
	}
}




// } Driver Code Ends


class Solution{
    
    // temp: input array
    // n: size of array
    //Function to rearrange  the array elements alternately.
    public static void rearrange(long arr[], int n){
        
        // int i =0;
        // int j = n-1;
        // int k = 0;
        // Arrays.sort(arr);
        // long ans[] = new long[n];
        // while(i<j){
        //     if(i==j){
        //         ans[k++] = arr[i];
        //     }
            
        //     ans[k] = arr[j];
        //     k++;
        //     j--;
        //     ans[k] = arr[i];
        //     k++;
        //     i++;
        // }
        // for(int l = 0;l<n;l++){
        //     arr[l] = ans[l];
        // }
        long arr2[]=Arrays.copyOf(arr,n);
        
        int i=0;
        int j=arr.length-1;
        int k=0;
        while(i<=j){
            if(k%2==0){
            arr[k++]=arr2[j--];
            }
            else{
                arr[k++]=arr2[i++];
            }
        }
        
    }
    
}


