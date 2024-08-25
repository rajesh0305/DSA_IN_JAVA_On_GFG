//{ Driver Code Starts
import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])throws IOException
        {
            BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());
            while(t-->0)
                {
                    String s = br.readLine();
                    Solution ob = new Solution();
                    System.out.println(ob.reverseString(s));
                }
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String reverseString(String s)
    {
        //code here.
        // ArrayList<Character>ans = new ArrayList<>();
        // for(int i = 0;i<s.length();i++){
        //     char ch=s.charAt(i);
        //     if(!ans.contains(ch)){
        //         ans.add(ch);
        //     }
        // }
        // String res = "";
        // for(int i = ans.size()-1;i>=0;i--){
        //     if(ans.get(i)!=' '){
        //     res = res+ans.get(i);
        // }
        // }
        // return res;
        s = s.replaceAll(" ","");
        StringBuilder sb = new StringBuilder(s);
        sb = sb.reverse();
        String l = "";
        for(int i = 0;i<sb.length();i++)
        {
            char x = sb.charAt(i);
            if(l.indexOf(x) == -1)
            l+=x;
        }
        return l;
    }
}