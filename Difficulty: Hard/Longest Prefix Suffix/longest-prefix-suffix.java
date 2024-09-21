//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.lps(s));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
       public static void findPrefix(String str, ArrayList<String> arr) {
        String s = "";
        for (int i = 0; i < str.length()-1; i++) {  
            s = s + str.charAt(i);
            arr.add(s);
        }
    }

    public static void findSuffix(String str, ArrayList<String> arr) {
        String s = "";
        for (int i = str.length() - 1; i >= 0; i--) {  
            s = str.charAt(i) + s;  
            arr.add(s);
        }
    }
    int lps(String str) {
        // code here
        // ArrayList<String>prefix = new ArrayList<>();
        // ArrayList<String>suffix  = new ArrayList<>();
        // findPrefix(str,prefix);
        // findSuffix(str,suffix);
        // int len = 0;
        // for (int i = 0; i < prefix.size(); i++) {
        //     String inter = prefix.get(i);
        //     if (suffix.contains(inter)) {  
        //         len = Math.max(len, inter.length());
        //     }
        // }
        // return len;
        int length = str.length();
        int lps[] = new int[length];  
        lps[0]=0; 
        int suff =1;
        int pref= 0;
        while(suff<length){
        if(str.charAt(suff)==str.charAt(pref)){
            pref++;
            lps[suff]=pref;
            suff++;
           }else{
              if(pref!=0){
                pref= lps[pref-1];
            } else{
           lps[suff]=0;
           suff++;
            }
          }
        }
        return  lps[length-1];
    }
}