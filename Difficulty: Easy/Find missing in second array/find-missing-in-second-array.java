//{ Driver Code Starts
//Initial Template for Java





import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java



class Solution
{
    public static ArrayList<Integer> navie(int arr1[],int arr2[]){
        ArrayList<Integer>ans = new ArrayList<Integer>();
        for(int i = 0;i<arr1.length;i++){
            int ele = arr1[i];
            for(int j = 0;j<arr2.length;j++){
                if(arr1[i]==ele){
                    ans.add(ele);
                }
            }
        }
        return ans ;
    }
    ArrayList<Integer> findMissing(int a[], int b[], int n, int m)
    {
        HashMap<Integer,Integer>hm = new HashMap<>();
        for(int i = 0;i<b.length;i++){
            if(!hm.containsKey(b[i])){
                hm.put(b[i],1);
            }else{
                hm.put(b[i],hm.get(b[i])+1);
            }
        }
        ArrayList<Integer>ans = new ArrayList<Integer>();
        for(int i=0;i<a.length;i++){
            int ele = a[i];
          if(!hm.containsKey(ele)){
              ans.add(ele);
          }
        }
        return ans;
    }
}


//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
//            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] q = line.trim().split("\\s+");
            int n =Integer.parseInt(q[0]);
            int m =Integer.parseInt(q[1]);
            //int y =Integer.parseInt(q[2]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(a1[i]);
            }
            String line2 = br.readLine();
            String[] a2 = line2.trim().split("\\s+");
            int b[] = new int[m];
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(a2[i]);
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans=ob.findMissing(a,b,n,m);
            for (int i = 0; i < ans.size(); i++) {
                System.out.print(ans.get(i)+" ");
            }
            System.out.println();

        }
    }
}



// } Driver Code Ends