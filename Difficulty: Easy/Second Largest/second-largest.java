//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] arr1Str = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(arr1Str).mapToInt(Integer::parseInt).toArray();
            Solution ob = new Solution();
            int ans = ob.getSecondLargest(arr);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int findmax(int arr[]){
        int max = Integer.MIN_VALUE;
        int index = 0;
        for(int i = 0;i<arr.length;i++){
            int ele = arr[i];
            if(ele>max){
                max = ele;
                index = i;
            }
        }
        return index;
    }
    public int getSecondLargest(int[] arr) {
        // Code Here
       int max1 =-1;
       int max2= -1;
       for(int i = 0;i<arr.length;i++){
           if(arr[i]>max1){
               max2 =max1;
               max1 =arr[i];
           }else if(arr[i]>max2 && arr[i]<max1){
               max2= arr[i];
           }
       }
       return max2;
    }
}