//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            long n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.convertEvenBitToZero(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    public static long bystring(long n){
                String str = Long.toBinaryString(n);
         
        if (str.length() % 2 == 1) {
            str = "0" + str;
        }
        
        char[] arr = str.toCharArray();
        for (int i = 1; i < arr.length; i += 2) {
            arr[i] = '0';
        }

        return Long.parseLong(new String(arr), 2);
    }
    public static long bybitmethod(long n){
        for(int i=0;i<32;i++)
        if(i%2==0){
             if(((1<<i)&n)>0){
           n=n^(1<<i);     
        }   
    }
return n;
    }
    // public static int BitTraversal(long n){
    //     long num1=0,num2=0;
    //     for(long i=n;i;i>>=2){
    //         if(i&1==1) 
    //             num1+=(1<<num2);
    //         num2+=2;
    //     }
    //     return n-num1;
    // }
    static long convertEvenBitToZero(long n) {
        // code here
        //BitTraversal(n);
        return (n&0xaaaaaaaa);
    }
}