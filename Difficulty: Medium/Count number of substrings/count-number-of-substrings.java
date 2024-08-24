//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String s = sc.next ();
            int k = sc.nextInt();
    		System.out.println (new Solution().substrCount (s, k));
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static boolean check(String s,int k){
        HashSet<Character>hs = new HashSet<>();
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
                hs.add(ch);
        }
        if(hs.size()==k){
            return true;
        }else
        return false;
    }
     // Helper function to calculate the count of substrings with at most k distinct characters
    static long calcCount(String s, int k) {
        int i = 0;
        int j = 0;
        int n = s.length();
        int[] charFreq = new int[26]; // Array to store the frequency of characters
        int dist_count = 0; // Variable to keep track of distinct characters
        long ans = 0; // Variable to store the final count

        while (j < n) {
            charFreq[s.charAt(j) - 'a']++;

            // If the character becomes distinct, increment the distinct count
            if (charFreq[s.charAt(j) - 'a'] == 1) {
                dist_count++;
            }

            // Decreasing the window size to maintain at most k distinct characters
            while (dist_count > k) {
                charFreq[s.charAt(i) - 'a']--;

                // If the frequency becomes 0, decrement the distinct count
                if (charFreq[s.charAt(i) - 'a'] == 0) {
                    dist_count--;
                }

                // Move the window's starting point to the right
                i++;
            }

            // Update the count by adding the current window size
            ans += (j - i + 1);
            
            // Move the window's ending point to the right
            j++;
        }

        return ans;
    }
    long substrCount (String S, int K) {
        // your code here
        // int count = 0;
        // int n = S.length();
        // for(int i = 0;i<n;i++){
        //     for(int j = i+1;j<=n;j++){
        //         String s = S.substring(i,j);
        //       if (s.length() >= K) {  
        //           boolean flag = check(s, K);
        //             if (flag) {
        //                 count++;
        //             }
        //         }
        //     }
        // }
        // return count;
         return calcCount(S, K) - calcCount(S, K - 1);
    }
}