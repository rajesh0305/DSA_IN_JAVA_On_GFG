//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String A = br.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.FirstNonRepeating(A);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution
{
    public static String ans(String A){
   HashMap<Character,Integer> c=new HashMap<>();
    HashMap<Character,Integer> h=new HashMap<>();
char a[]=A.toCharArray();
StringBuilder ans=new StringBuilder("");
int n=A.length();
for(int i=0;i<n;i++){
    c.put(a[i],c.getOrDefault(a[i],0)+1);
    h.put(a[i],i);
    //System.out.println(c);
    char k='#';int min=i;
      for (Map.Entry<Character, Integer> j : c.entrySet()) {
         if(j.getValue()==1){
          if(h.get(j.getKey())<=min){
              min=h.get(j.getKey());
              k=j.getKey();
            //  System.out.println(j.getValue()+" "+j.getKey());
          }      
         }
      }
    //  System.out.println(k+" "+min);
    ans.append(k+"");
}

return ans.toString();
    }
    public String FirstNonRepeating(String A)
    {
        // code here
        StringBuilder ans= new StringBuilder();
        HashMap<Character, Integer> map= new HashMap<>();
        Queue<Character> qu = new LinkedList<>();
        for(int x=0;x<A.length() ; x++)
        {
            char ch= A.charAt(x);
            if(!map.containsKey(ch))
            {
                map.put(ch,1);
                qu.add(ch);
            }
            else
            {
                map.put(ch, map.get(ch) + 1);
            }
            
            while(qu.size()!=0 && map.get(qu.peek())>1 )
            {
                qu.remove();
            }
            if(qu.isEmpty())
                ans.append('#');
            else
                ans.append(qu.peek());
        }
        return ans.toString();
        
    }
}