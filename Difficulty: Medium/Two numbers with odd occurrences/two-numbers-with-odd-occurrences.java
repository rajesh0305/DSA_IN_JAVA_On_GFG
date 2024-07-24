//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int Arr[]= new int[N];
            for(int i = 0; i < N; i++)
                Arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int[] ans = ob.twoOddNum(Arr,N);
            for(int i = 0; i < ans.length; i++)
            {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//User function Template for Java
class Solution
{
    public int[] twoOddNum(int Arr[], int N)
    {
        // code here
       // ArrayList<Integer> ans= new ArrayList<>();
        HashMap<Integer,Integer>hm = new HashMap<>();
        for(int i = 0;i<N;i++){
            int ele = Arr[i];
            if(!hm.containsKey(ele)){
                hm.put(ele,1);
            }else{
                hm.put(ele,hm.get(ele)+1);
            }
        }
      int[] res = new int[2]; 
        int i=0;
        for(Map.Entry<Integer, Integer> e : hm.entrySet()){
            if(e.getValue()%2!=0){
                res[i] = e.getKey();
                i++;
                if(i>=2){
                    break;
                }
            }
    }
    int[] newRes = new int[2];
        newRes[0] = Math.max(res[0], res[1]);
        newRes[1] = Math.min(res[0], res[1]);
        return newRes;
}
}