//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(read.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            Solution ob = new Solution();
            int[] ans = ob.leafNodes(arr, N);
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
class Solution
{
    public int[] leafNodes(int arr[], int N)
    {
        // code here
        List<Integer> v=new Vector<>();
        
        Stack<Integer> st=new Stack<>();
        //push top root
        st.push(arr[0]);
        
        for(int i=1;i<arr.length;i++){
            if(st.peek()>arr[i]) st.push(arr[i]);
            else {
                int val=st.peek(), cnt=0;
                while(!st.isEmpty()&&st.peek()<arr[i]){
                    st.pop();
                    cnt++;
                }
                st.push(arr[i]);
                if(cnt>1)v.add(val);
            }
        }
        
        v.add(st.pop());
        
        int[] ans=new int[v.size()];
        for(int i=0;i<ans.length;i++){
            ans[i]=v.get(i);
        }
        return ans;
    }
}