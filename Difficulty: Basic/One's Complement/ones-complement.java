//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.onesComplement(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static int onesComplement(int N){
        //code here\
    String str=Integer.toBinaryString(N);
        String s="";
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)=='1')
                s += '0';
            else
                s += '1';
        }

        int n = Integer.parseInt(s,2);

        return n;
    }
}