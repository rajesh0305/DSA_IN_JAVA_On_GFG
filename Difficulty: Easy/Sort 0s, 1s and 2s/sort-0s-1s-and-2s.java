//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            String[] inputArray = input.split("\\s+");
            ArrayList<Integer> a = new ArrayList<>();

            for (String s : inputArray) {
                a.add(Integer.parseInt(s));
            }

            Solution ob = new Solution();
            ob.sort012(a);

            for (int num : a) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to sort an array of 0s, 1s, and 2s
    public void sort012(ArrayList<Integer> arr) {
        // code here
        // int zero = 0;
        // int one  = 0;
        // int two = 0;
    //     ArrayList<Integer>zero = new ArrayList<Integer>();
    //     ArrayList<Integer>one = new ArrayList<Integer>();
    //     ArrayList<Integer>two = new ArrayList<Integer>();
    //     for(int i = 0;i<arr.size();i++){
    //         if(arr.get(i)==0){
    //             zero.add(arr.get(i));
    //         }
    //     }
    //     for(int i = 0;i<arr.size();i++){
    //         if(arr.get(i)==1){
    //             one.add(arr.get(i));
    //         }
    //     }
    //     for(int i = 0;i<arr.size();i++){
    //         if(arr.get(i)==2){
    //             two.add(arr.get(i));
    //         }
    //     }
    //   for(int i = 0;i<zero.size();i++){
    //       arr.add(0);
    //   }
    //   for(int i =0;i<one.size();i++){
    //       arr.add(1);
    //   }
    //   for(int i =0;i<two.size();i++){
    //       arr.add(2);
    //   }
    Collections.sort(arr);
    }
}