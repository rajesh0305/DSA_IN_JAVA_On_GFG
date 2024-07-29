//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.math.*;

class Multiply{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String a=sc.next();
            String b=sc.next();
            Solution g=new Solution();
            System.out.println(g.multiplyStrings(a,b));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String multiplyStrings(String s1,String s2)
    {
        //code here.
        // int dec1 = 0;
        // int dec2 = 0;
        // int p = 0;
        // int i= s1.length()-1;
        // int j = s2.length()-1;
        // while(i>=0){
        //     char ch=  s1.charAt(i);
        //     int ele =ch-'0';
        //     dec1 = dec1+ele*(int)Math.pow(10,p);
        //     p++;
        // }
        //   while(j>=0){
        //     char ch=  s1.charAt(j);
        //     int ele =ch-'0';
        //     dec2 = dec2+ele*(int)Math.pow(10,p);
        //     p++;
        // }
        // int mul =dec1*dec2;
        // String s = "";
        // int k = 0;
        // while(mul>0){
        //     int last =mul%10;
        //     s = last+s;
        //     mul = mul/10;
        // }
        // return s;
         String product = "";
        BigInteger a = new BigInteger(s1);
        BigInteger b = new BigInteger(s2);
        BigInteger mul = a.multiply(b);
        product = product + mul.toString();
        return product;
    }
}