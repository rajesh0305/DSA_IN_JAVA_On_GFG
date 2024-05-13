//{ Driver Code Starts
import java.util.*;

class MaxLenZeroSumSub
{

    // Returns length of the maximum length subarray with 0 sum

    // Drive method
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            GfG g = new GfG();
            System.out.println(g.maxLen(arr, n));
            T--;
        }
    }
}
// } Driver Code Ends


class GfG
{
    int maxLen(int arr[], int n)
    {
        //Approach (1)-->O(n^3)
        // int maxlen = 0;
        // for(int i = 0;i<arr.length;i++){
        //     for(int j = i;j<arr.length;j++){
        //          int sum =0;
        //         for(int k = i;k<=j;k++)
        //             sum = sum+arr[k];
        //               if(sum==0){
        //                  if(maxlen<j-i+1)
        //                      maxlen = j-i+1;
        //               }
        //           }
        //      }
        // return maxlen;
        
        //Approach(2)-->O(n^2)
        
        // int maxlen =0;
        // for(int i= 0;i<arr.length;i++){
        //     int sum = 0;
        //     for(int j = i;j<arr.length;j++){
        //         sum = sum+arr[j];
        //         if(sum ==0){
        //             maxlen = Math.max(maxlen,j-i+1);
        //         }
        //     }
        // }
        // return maxlen;
        
        // Approach(3) using HashMap()--->O(n)
        
        int maxlen = 0;
        int sum =0;
        HashMap<Integer,Integer>map= new HashMap<Integer,Integer>();
        for(int i = 0;i<arr.length;i++){
            sum = sum+arr[i];
            if(sum==0){
                maxlen = i+1;
            }else{
                if(map.get(sum)!=null){
                    maxlen = Math.max(maxlen,i-map.get(sum));
                }else{
                    map.put(sum,i);
                }
            }
        }
        return maxlen;
       
    }
}