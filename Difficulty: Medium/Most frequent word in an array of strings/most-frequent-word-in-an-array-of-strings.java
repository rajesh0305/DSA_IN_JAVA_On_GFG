//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main(String[] args) throws IOException{
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		while(t-->0)
		{
		    int n=sc.nextInt();
		    sc.nextLine();
		    Solution obj = new Solution();
		    String arr[]=sc.nextLine().split(" ");
		    System.out.println(obj.mostFrequentWord(arr, n));
		    
		}
	}
}

// } Driver Code Ends
//User function Template for Java


class Solution
{
    //Function to find most frequent word in an array of strings.
    public String mostFrequentWord(String arr[],int n)
    {
        // code here
        HashMap<String, Integer>map= new HashMap<String ,Integer>();
        for(int i = 0;i<arr.length;i++){
            String str = arr[i];
            if(map.containsKey(str)){
                map.put(str,map.get(str)+1);
            }else{
                map.put(str,1);
            }
        }
          String res="";
        int max=0;
        HashSet<String> s=new HashSet<>();
        for(int i=0;i<n;i++){
            if(max<map.get(arr[i])){
                res=arr[i];
                s.add(arr[i]);
                max=map.get(arr[i]);
            }
            else if(max==map.get(arr[i]) && s.contains(arr[i])==false){
                res=arr[i];
                s.add(arr[i]);
            }
        }
        
        return res;
        
    }

}


//{ Driver Code Starts.
// } Driver Code Ends