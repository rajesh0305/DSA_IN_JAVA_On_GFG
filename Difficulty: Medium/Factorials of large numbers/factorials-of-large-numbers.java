//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java
//import java.util.BigInteger;
class Solution {
    public static int facto(int n){
        int fact =1;
        // if(n==1){
        //     return 1;
        // }
        // fact = n*facto(n-1);
        // return fact;
        for(int i = 1;i<n;i++){
            fact = fact*i;
        }
        return fact;
    }
    public static void reverse(ArrayList<Integer>arr){
        int start = 0;
        int end =arr.size()-1;
        while(start<end){
            int temp = arr.get(end);
            arr.add(arr.get(start));
            arr.add(temp);
        }
    }
    public static ArrayList<Integer>sol1(int N){
        ArrayList <Integer> answer = new ArrayList<>();
        answer.add(1);
        
        for(int i = 2;i<=N;i++){
            int size = answer.size(), carry = 0;
            for(int j = 0;j<size;j++){
                int num = answer.get(j) * i + carry;
                answer.set(j, num % 10);
                carry = num /10;
            }
            while(carry != 0){
                answer.add(carry % 10);
                carry/=10;
            }
        }
        
        Collections.reverse(answer);
        return answer;
    }
    // public static ArrayList<Integer>sol2(int N){
    //               ArrayList<Integer> result = new ArrayList<>();

    //     BigInteger factorial = BigInteger.ONE;
    //     for (int i = 1; i <= N; i++) {
    //         factorial = factorial.multiply(BigInteger.valueOf(i));
           
    //     }
    //     String s=factorial+"";
        
    //     for(int i=0;i<s.length();i++){
    //         result.add((int)s.charAt(i)-48);
    //     }
    //      return result; 
    // }
    static ArrayList<Integer> factorial(int N) {
        // code here
    //   int fact= facto(N);
    //  ArrayList<Integer>ans = new ArrayList<Integer>();
    //   while(fact>0){
    //       int last = fact%10;
    //       ans.add(last);
    //       fact = fact/10;
    //   }
    //  // return ans;
    //   reverse(ans);
    //   return ans;
    return sol1(N);
    }
}

//{ Driver Code Starts.

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.factorial(N);
            for (Integer val : ans) System.out.print(val);
            System.out.println();
        }
    }
}
// } Driver Code Ends