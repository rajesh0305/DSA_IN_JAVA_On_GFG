//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;

class GfG {
    

	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String S[] = br.readLine().split(" ");
            
            long a = Long.parseLong(S[0]);
            
            long b = Long.parseLong(S[1]);
	       
	    	Solution ob = new Solution();
           
            System.out.println(ob.divide(a,b));
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static long bruteforce(long a,long b){
        long sum = 0;
        long count= 0;
        while(sum+b<=a){
            count = count+1;
            sum =sum+b;
        }
        return count;
    }
    public static long better(long dividend,long divisor){
        if(dividend==divisor){
            return 1;
        }
        long ans= 0;
        boolean sign = true;
        if(dividend>=0 && divisor<0 || dividend<0 && divisor>=0){
            sign = false;
        }
        long n =Math.abs(dividend);
        long d= Math.abs(divisor);
        
        while(n>=d){
            int count = 0;
            while(n>=(d<<count+1)){
                count++;
            }
            ans = ans+(1<<count);
            n = n-(d*(1<<count));
        }
        if(ans>=(1<<31)  && sign==true){
        return Integer.MAX_VALUE;}
        if(ans>=(1<<31) && sign==false){
        return Integer.MIN_VALUE;}
        return (sign)?ans:(-1*ans);
    }
    public static long division(long dividend, 
                        long divisor) 
{ 
 
// Calculate sign of divisor 
// i.e., sign will be negative 
// only if either one of them 
// is negative otherwise it 
// will be positive 
long sign = ((dividend < 0) ^ 
            (divisor < 0)) ? -1 : 1; 
 
// remove sign of operands 
dividend = Math.abs(dividend); 
divisor = Math.abs(divisor); 
 
// Initialize the quotient 
long quotient = 0, temp = 0; 
 
// test down from the highest 
// bit and accumulate the 
// tentative value for 
// valid bit 
// 1<<31 behaves incorrectly and gives Integer
// Min Value which should not be the case, instead 
  // 1L<<31 works correctly. 
for (int i = 31; i >= 0; --i) 
{ 
 
    if (temp + (divisor << i) <= dividend) 
    { 
        temp += divisor << i; 
        quotient |= 1L << i; 
    } 
} 
 
//if the sign value computed earlier is -1 then negate the value of quotient
if(sign==-1) 
  quotient=-quotient;
return quotient; 
} 
    public static long divide(long a, long b)
    {
        //code here
    //return bruteforce(a,b);
    //return better(a,b);
    return division(a,b);
    }
}