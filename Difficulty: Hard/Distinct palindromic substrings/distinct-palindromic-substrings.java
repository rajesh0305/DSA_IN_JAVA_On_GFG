//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            String str = read.readLine().trim(); 
            Solution obj = new Solution();
            int ans = obj.palindromeSubStrs(str);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{ 
    public static boolean check(String s){
        int n = s.length();
        if(n==1){
            return true;
        }
        int i = 0;
        int j= n-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    int palindromeSubStrs(String str) { 
        // code here  
        HashSet<String>hs = new HashSet<>();
        // int count = 0;
        // for(int i = 0;i<str.length();i++){
        //     for(int j = i+1;j<=str.length();j++){
        //         String s = str.substring(i,j);
        //         boolean flag = check(s);
        //         if(flag==true){
        //             //count = count+1;
        //             hs.add(s);
        //         }
        //     }
        // }
        // return hs.size();
        String s = "";
        s = s+str;
       if(s.length() == 1)return 1;
        
        HashMap<String, Integer> hm = new HashMap<>();
        
        for(int i = 0; i < s.length(); ++i){
            String temp = s.substring(i, i + 1);
            hm.put(temp, hm.getOrDefault(temp, 0) + 1);
            
            //get odd length of palindromes
            int left1 = i - 1;
            int right1 = i + 1;
            while(left1 >= 0 && right1 < s.length()){
                if(s.charAt(left1) == s.charAt(right1)){
                    String temp1 = s.substring(left1, right1 + 1);
                    hm.put(temp1, hm.getOrDefault(temp1, 0) + 1);
                    left1--;
                    right1++;
                }else{
                    break;
                }
            }
            
            //get even length of palindromes
            int left2 = i;
            int right2 = i+1;
            
            while(left2 >= 0 && right2 < s.length()){
                if(s.charAt(left2) == s.charAt(right2)){
                    String temp2 = s.substring(left2, right2 + 1);
                    hm.put(temp2, hm.getOrDefault(temp2, 0) + 1);
                    left2--;
                    right2++;
                }else{
                    break;
                }
            }
        }
        
        return hm.size();
    }
} 