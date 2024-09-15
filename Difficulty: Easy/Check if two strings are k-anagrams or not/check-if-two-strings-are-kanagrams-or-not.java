//{ Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.lang.*;
class GFG {
    public static void main(String[] args)
    {   Scanner sc = new Scanner(System.in);
    	int t=sc.nextInt();
    	while(t-->0)
    	{
    		String str1=sc.next();
    		String str2=sc.next();
    		int k=sc.nextInt();
            Solution ob = new Solution();
    		if (ob.areKAnagrams(str1, str2, k) == true)
    			System.out.println("1");
    		else
    			System.out.println("0");
    	}
    }
}
// } Driver Code Ends


//User function template for JAVA

class Solution {
    public static int lcs(String s,String t){
        int dp[][] = new int[s.length() + 1][t.length() + 1];
        
        // Filling dp table
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[s.length()][t.length()];
    }
    boolean areKAnagrams(String s1, String s2, int k) {
        // code here
        if(s1.length()!=s2.length()){
            return false;
        }
        // int len = lcs(s1,s2);
        // if(k==s1.length()-len){
        //     return true;
        // }
        // return false;
         int c=0;
        char[] t=s2.toCharArray();
        char[] f=s1.toCharArray();
        ArrayList<Character> a=new ArrayList<>();
        for(int i=0;i<s1.length();i++){
        a.add(f[i]);
        }
        for(int i=0;i<s2.length();i++){
            if(!a.contains(t[i])){
                c++;
            }else{
                a.remove(a.indexOf(t[i]));
            }
        }
        if(c<=k){
            return true;
        }
        return false;
    }
}