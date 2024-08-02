//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine();
            String[] S = s1.split(" ");
            String s = S[0];
            String t = S[1];
            Solution ob = new Solution();
            int ans = ob.editDistance(s, t);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int editDist(String str1,String str2,int m,int n){
        if(m==0){
            return n;
        }
        if(n==0){
            return m;
        }
        if(str1.charAt(m-1)==str2.charAt(n-1)){
            return editDist(str1,str2,m-1,n-1);
        }
        int s1= editDist(str1,str2,m-1,n);//repalce
        int s2= editDist(str1,str2,m,n-1);//delete
        int s3 = editDist(str1,str2,m-1,n-1);//remove
        int ans =1+min(s1,s2,s3);
        return ans;
    }
    public static int min(int x,int y,int z){
        int ans = Math.min(x,Math.min(y,z));
        return ans;
    }
 
    public static  int editDistance(String str1, String str2) {
        // Code here
      
        int n=str1.length();
        int m=str2.length();
        int dp[][]=new int[n+1][m+1];
        
        for(int j=0;j<=m;j++) dp[0][j]=j;
        for(int i=0;i<=n;i++)dp[i][0]=i;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else {
                    int insert=1+dp[i][j-1];
                    int remove=1+dp[i-1][j];
                    int replace=1+dp[i-1][j-1];
                    
                    dp[i][j]=Math.min(insert, Math.min(remove,replace));
                }
            }   
        }
        return dp[n][m];
    }
}