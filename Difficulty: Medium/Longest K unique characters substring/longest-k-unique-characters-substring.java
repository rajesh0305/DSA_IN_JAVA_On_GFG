//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int UsingHashMap(String s,int k){
            int n = s.length();
        HashMap<Character , Integer> map = new HashMap<>();
        int l = 0 , r = 0 , ans = 0;
        
        while(r < n){
            char c = s.charAt(r);
            map.put(c , map.getOrDefault(c , 0) + 1);
            
            if(map.size() > k){
                map.put(s.charAt(l) , map.get(s.charAt(l)) - 1 );
                if(map.get(s.charAt(l)) == 0){
                    map.remove(s.charAt(l));
                }
                l++;
            }
            if(map.size() == k){
                ans = Math.max(ans , r - l + 1);
            }
            r++;
        }
        return ans == 0 ? -1 : ans;
    }
    
    public int longestkSubstr(String s, int k) {
        // code here
        return UsingHashMap(s,k);
    }
}