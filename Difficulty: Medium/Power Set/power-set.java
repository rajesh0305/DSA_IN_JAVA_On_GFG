//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            Solution ob = new Solution();
            List<String> ans = ob.AllPossibleStrings(s);
            for(String i: ans)
                System.out.print(i + " ");
            System.out.println();
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public List<String> AllPossibleStrings(String s)
    {
        // Code here
         List<String> result = new ArrayList<>();
        int n = s.length();
        
        // There are 2^n possible substrings
        for (int i = 0; i < (1 << n); i++) {
            String sub = "";
            for (int j = 0; j < n; j++) {
                // Check if the jth bit is set in i
                if ((i & (1 << j)) > 0) {
                    sub += s.charAt(j);
                }
            }
            // Add non-empty substrings to the result
            if (!sub.isEmpty()) {
                result.add(sub);
            }
        }
        
        // Sort the result to return in lexicographical order
        Collections.sort(result);
        return result;
    }
}