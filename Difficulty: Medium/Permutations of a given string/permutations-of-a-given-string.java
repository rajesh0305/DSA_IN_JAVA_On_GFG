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
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                out.print(ans.get(i)+" ");
            }
            out.println();
                        
        }
        out.close();
	}
}


// } Driver Code Ends


class Solution {
        void rec(int index,char arr[],ArrayList<String>ans){
        if(index == arr.length){
            ans.add(new String(arr));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for(int i=index;i<arr.length;i++){
            if(set.contains(arr[i]))continue;
            set.add(arr[i]);
            swap(index,i,arr);
            rec(index+1,arr,ans);
            swap(index,i,arr);
        }
    }
    
    void swap(int index1,int index2,char arr[]){
        char t = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = t;
    }
    public static String sortstring(String str){
        //convert string into array.
        char temp[]=str.toCharArray(); 
        // sorting the array.
        Arrays.sort(temp); 
       //converting to string and returning. 
        return new String(temp); 
    }
    
    public static void permutation(String str,String perm,ArrayList<String> arr){
        // if all charater are used in string then add it to list . 
        if(str.length()==0){ 
            //check if list contain the same pattern or not.
            if(!arr.contains(perm)){ 
                arr.add(perm);
            }
            return;
        }
        for (int i=0;i<str.length();i++){
            // choose one character from string.
            char curr=str.charAt(i); 
            //remove the chosen character from string (as we have used that character).
            String newStr=str.substring(0,i)+str.substring(i+1);
            // go forward for the remaining character.  
            permutation(newStr,perm+curr,arr); 
        }
    }
    
    public List<String> find_permutation(String S) {
        // Code here
        //         ArrayList<String>ans = new ArrayList<>();
        // char arr [] = S.toCharArray();
        // rec(0,arr,ans);
      
        // Collections.sort(ans,String.CASE_INSENSITIVE_ORDER);
        // return ans
           ArrayList<String> arr=new ArrayList<>();
        S=sortstring(S);
        permutation(S,"",arr);
        return arr;
    }
}