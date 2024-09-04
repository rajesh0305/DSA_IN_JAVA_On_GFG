//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String input[] = read.readLine().split(" ");
            String a = input[0];
            
            Solution ob = new Solution();
            if(ob.sameFreq(a)){
                System.out.println(1);
            }
            else{
                System.out.println(0);
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public static int  find(ArrayList<Integer>ans){
        int res =ans.get(0);
        for(int i = 1;i<ans.size();i++){
            res = res^ans.get(i);
        }
       return res;
    }
    boolean sameFreq(String s) {
        // code here
        Map<Integer,Integer> counts = new HashMap<>();
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
            
        }
        for(int count:map.values()){
            counts.put(count,counts.getOrDefault(count,0)+1);
        }
        if(counts.size()==1)
            return true;
        if(counts.size()>2)
            return false;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int count:counts.keySet()){
            min=Math.min(min,count);
            max=Math.max(max,count);
        }
        if(counts.get(max)==1&&max-min == 1)
            return true;
        if(counts.get(min)==1&&min==1&&max-min >= 1)
            return true;
        return false;
    }
}