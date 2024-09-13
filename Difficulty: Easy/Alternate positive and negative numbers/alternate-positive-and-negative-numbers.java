//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String input = br.readLine();
            String[] inputArray = input.split("\\s+");
            ArrayList<Integer> arr = new ArrayList<>();

            for (String s : inputArray) {
                arr.add(Integer.parseInt(s));
            }

            new Solution().rearrange(arr);
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    void rearrange(ArrayList<Integer> arr) {
        // code here
    ArrayList<Integer>neg=new ArrayList<>();
        ArrayList<Integer>pos=new ArrayList<>();
        ArrayList<Integer> res=new ArrayList<>();
        for(int n:arr){
            if(n<0)neg.add(n);
            else pos.add(n);
        }
        int n=0,p=0;
        while(n<neg.size() && p<pos.size()){
            res.add(pos.get(p++));
            res.add(neg.get(n++));
        }
        while(p<pos.size())res.add(pos.get(p++));
        while(n<neg.size())res.add(neg.get(n++));
        arr.clear();
        arr.addAll(res);
     
    }
}