//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            String[] S = br.readLine().trim().split(" ");
            int[] nums = new int[n+m];
            for(int i = 0; i < S.length; i++)
                nums[i] = Integer.parseInt(S[i]);
            Solution obj = new Solution();
            obj.sortLastMelements(nums, n, m);
            for(int i = 0; i < nums.length; i++){
                System.out.print(nums[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
     public void msort(int arr[],int i,int j){
        if(i >= j)return;
        int mid = i+(j-i)/2;
        msort(arr,i,mid);
        msort(arr,mid+1,j);
        merge(arr,i,mid,j);
    }
    public void merge(int arr[],int l,int mid,int r){
        int n1 = mid-l+1;
        int n2 = r-mid;
        int left[] = new int[n1];
        int right[] = new int[n2];
        for(int i = 0; i < n1 ; i++)left[i] = arr[i+l];
        for(int i = 0; i < n2 ; i++)right[i] = arr[i+mid+1];
        int i =0;
        int j =0;
        int k = l;
        while(i < n1 && j < n2){
            if(left[i] < right[j])arr[k++]=left[i++];
            else arr[k++] = right[j++];
        }
        while(i < n1)arr[k++] = left[i++];
        while(j < n2)arr[k++] = right[j++];
    }
    public void sortLastMelements(int[] nums, int n, int m)
    {
        // Code here
    //   ArrayList<Integer>left =new ArrayList<Integer>();
    //   ArrayList<Integer>right =new ArrayList<Integer>();
    //   for(int i = 0;i<nums.length;i++){
    //       if(i<m){
    //           left.add(nums[i]);
    //       }else{
    //           right.add(nums[i]);
    //       }
    //   }
    //   Collections.sort(left);
    //   Collections.sort(right);
    //   int k = 0;
    //   for(int i = 0;i<left.size();i++){
    //       nums[k++] = left.get(i);
    //   }
    //   for(int i =0;i<right.size();i++){
    //       nums[k++] = right.get(i);
    //   }
    msort(nums,n,nums.length-1);
    }
}