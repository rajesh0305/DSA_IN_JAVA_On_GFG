//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            Solution ob = new Solution();
            List<Integer> ans = ob.get(a,b);
            System.out.println(ans.get(0)+" "+ans.get(1));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public static void WithTemp(int a,int b){
        int temp = a;
        a = b;
        b = a;
    }
    public static void WithoutTemp(int a,int b){
        a= a+b;
        b = a-b;
        a= a-b;
    }
    public static List<Integer> UsingOperator(int a,int b){
        // here we are using XOR operator
        List<Integer>ans = new ArrayList<>();
        a = a^b;
        b = a^b;
        a = a^b;
        ans.add(a);
        ans.add(b);
        return ans;
    }
    static List<Integer> get(int a,int b)
    {
        // code here
        List<Integer>ans = new ArrayList<>();
        return UsingOperator(a,b);
        
    }
}