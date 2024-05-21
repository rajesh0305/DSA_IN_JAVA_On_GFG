//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    public static boolean isMerged(int[] a, int[] b, int[] merged){
        if(a.length + b.length != merged.length)
            return false;
        
        int[] m = new int[merged.length];
        int i = 0;
        for(int e : a)
            m[i++] = e;
        for(int e : b)
            m[i++] = e;
        Arrays.sort(m);
        int[] mergedCopy = Arrays.copyOf(merged, merged.length);
        Arrays.sort(mergedCopy);
        if(!Arrays.equals(m, mergedCopy))
            return false;
        
        for(i = 1; i < merged.length; i++){
            if(merged[i] > merged[(i-1)/2])
                return false;
        }
        
        return true;
    }
    
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            int n = Integer.parseInt(stt.nextToken());
            int m = Integer.parseInt(stt.nextToken());
            int a[] = new int[n];
            int b[] = new int[m];
            int merged[];
            
            
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            String inputLine1[] = br.readLine().trim().split(" ");
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(inputLine1[i]);
            }
            
            
            Solution obj = new Solution();
            int[] copyA = Arrays.copyOf(a, a.length), copyB = Arrays.copyOf(b, b.length);
            merged = obj.mergeHeaps(a, b, n, m);
            
            boolean flag = isMerged(copyA, copyB, merged);
            System.out.println(flag ? 1 : 0);
        }
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution{
    // public static int[] reverse(int arr[]){
    //     int rev[] = new int [arr.length];
    //     int i =arr.length-1;
    //     int k =0;
    //     while(i>=0){
    //         rev[k] = arr[i];
    //     }
    //     return rev;
    // }
      public static void hepify(int[] arr,int vv,int mm){
        int max=vv;
        int ll=vv*2+1;
        int rr=vv*2+2;
        if(ll<mm && arr[ll]>arr[max])
            max=ll;
        if(rr<mm && arr[rr]>arr[max])
            max=rr;
        if(max!=vv)
        {
            int temp=arr[vv];
            arr[vv]=arr[max];
            arr[max]=temp;
            hepify(arr,max,mm);
        }
}
    public int[] mergeHeaps(int[] a, int[] b, int n, int m) {
        // your code here
        //Approach 1-->O((n+m)log(n+m)) time complexity
        // int ans[] = new int[n+m];
        // int k = 0;
        // for(int i =0;i<n;i++){
        //     ans[k] =a[i];
        //     k++;
        // }
        // for(int i= 0;i<m;i++){
        //     ans[k] = b[i];
        //     k++;
            
        // }
        // Arrays.sort(ans);
        // int arr[] = reverse(ans);
        
        // return arr;
    
 // Approach 2-->
    int nn=n+m;
        int[] ans=new int[n+m];
        int i=0;
        for(int kk:a)
        {
            ans[i++]=kk;
        }
        for(int kk:b)
        {
            ans[i++]=kk;
        }
        for(int vv=nn/2; vv>=0; vv--)
        {
            hepify(ans,vv,nn);
        }
        return ans;
    
        
         // Approach 3-->O(n) time complexity
        // int ans[] = new int [n+m];
        // int i= 0;
        // int j = 0;
        // int k = 0;
        // while(i<n && j<m){
        //   if(a[i]>=b[j]){
        //       ans[k] = a[i];
        //       k++;
        //       i++;
        //   }else{
        //       ans[k] =b[j];
        //       k++;
        //       j++;
        //   }
        // }
        // while(i<n){
        //     ans[k] = a[i];
        //     k++;
        //     i++;
        // }
        // while(j<m){
        //     ans[k] = b[j];
        //     k++;
        //     j++;
        // }
        // return ans;
    }
}