//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int [][]arr = new int[n][m];
            
            for (int i = 0; i < n; ++i)
                for (int j = 0; j < m; ++j)
                    arr[i][j] = sc.nextInt ();

    		System.out.println (new Sol().maxOnes (arr, n, m));
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java

class Sol
{
    public static int count(int mat[],int m){
        int one  = 0;
        for(int i = 0;i<m;i++){
            if(mat[i]==1){
                one++;
            }
        }
        return one;
    }
    public static int maxOnes (int Mat[][], int N, int M)
    {
        // your code here
        int max = 0;
        int index =0;
        for(int i = 0;i<N;i++){
            int count_one = count(Mat[i],M);
            // max = Math.max(max,count_one);
            if(max<count_one){
                max  = count_one;
                 index = i;
            }
           
        }
        return index;
    }
}