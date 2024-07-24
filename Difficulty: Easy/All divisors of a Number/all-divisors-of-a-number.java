//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            obj.print_divisors(n);
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public static void print_divisors(int n) {
        // code here
    ArrayList<Integer>ans=new ArrayList<>();
       for(int i=1;i*i<=n;i++){
           if(n%i==0){
               ans.add(i);
          
           if(n/i!=i){
               ans.add(n/i);
           }
           }
       }
       Collections.sort(ans);
       for(int i=0;i<ans.size();i++){
           System.out.print(ans.get(i)+" ");
       }
    }
}
