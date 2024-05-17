//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String A = sc.next();
                    String B = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.UncommonChars(A, B));
                }
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    String UncommonChars(String A, String B)
    {
        // code here
        char arr1[] = A.toCharArray();
        char arr2[] = B.toCharArray();
       ArrayList<Character>arr3 =new ArrayList<Character>();
       HashMap<String,Integer>map = new HashMap<String, Integer>();
        
       ArrayList<Character> list = new ArrayList<>();
        for(int i = 0; i < A.length() ; i++){
            char ch = A.charAt(i);
        if(!B.contains(ch+"") && !list.contains(ch))list.add(ch);
        }
        for(int i = 0; i < B.length() ; i++){
            char ch = B.charAt(i);
            if(!A.contains(ch+"") && !list.contains(ch))list.add(ch);
        }
        if(list.size() == 0)return "-1";
        Collections.sort(list);
        String a = "";
        for(char ch : list)a+=ch;
        return a;
        
    }
}