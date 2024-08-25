//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            long n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.isSumPalindrome(n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    public static long reverse(long n){
        long rev = 0;
        while(n>0){
            long last = n%10;
            rev = rev*10+last;
            n = n/10;
        }
        return rev;
    }
    public static boolean check(long n){
       
       ArrayList<Long>arr = new ArrayList<Long>();
       while(n>0){
           long last = n%10;
           arr.add(last);
           n = n/10;
       }
       int i =0;
       int j = arr.size()-1;
       while(i<j){
           if(arr.get(i)!=arr.get(j)){
               return false;
           }
       }
       return false;
    }
    static long isSumPalindrome(long n) {
        // code here
          long sum=n,rev=0;
        
        for(int i=0;i<=5;i++)
        {
            n=sum;
            rev=0;
            while(n>0)
            {
                rev=(rev*10)+n%10;
                n/=10;
            }
            if(rev==sum)
                return sum;
            sum+=rev;
        }
        
        return -1;
    }
}