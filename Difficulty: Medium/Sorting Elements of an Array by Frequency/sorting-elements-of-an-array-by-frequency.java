//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.Map.Entry;


// } Driver Code Ends
// User function Template for Java

class Solution {
    // Function to sort the array according to frequency of elements.
    public ArrayList<Integer> sortByFreq(int arr[]) {
        // add your code here
        
        // HashMap<Integer,Integer>freq = new HashMap<>();
        // for(int i = 0;i<arr.length;i++){
        //     int ele = arr[i];
        //     if(!freq.containsKey(ele)){
        //         freq.put(ele,1);
        //     }else{
        //         freq.put(ele,freq.get(ele)+1);
        //     }
        // }
        // Integer temp[] = new Integer[arr.length];
        // for(int i = 0;i<arr.length;i++){
        //     temp[i] = arr[i];
        // }
        // Arrays.sort(temp, new Comparator<Integer>() {
        //     public int compare(Integer a, Integer b) {
        //         int freqCompare = freq.get(b).compareTo(freq.get(a));
        //         if (freqCompare == 0) {
        //             return a - b;
        //         } else {
        //             return freqCompare;
        //         }
        //     }
        // });
        // ArrayList<Integer>ans = new ArrayList<>();
        // for(int i = 0;i<arr.length;i++){
        //     ans.add(temp[i]);
        // }
        // return ans;
        HashMap<Integer,Integer>map=new HashMap<>();
        
        ArrayList<Integer>list=new ArrayList<>();
        
        for(int a:arr)
        {
            map.put(a,map.getOrDefault(a,0)+1);
            list.add(a);
        }
        
        Collections.sort(list,(x,y)-> map.get(x)==map.get(y)?x-y:map.get(y)-map.get(x));
        
        return list;
    }
}

//{ Driver Code Starts.

class Driverclass {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sc.readLine());
        while (n != 0) {
            String input = sc.readLine();
            String[] inputs = input.split(" ");
            int[] arr = new int[inputs.length];

            for (int i = 0; i < inputs.length; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }

            ArrayList<Integer> ans = new ArrayList<Integer>();
            ans = new Solution().sortByFreq(arr);
            for (int i = 0; i < ans.size(); i++) System.out.print(ans.get(i) + " ");
            System.out.println();
            n--;
        }
    }
}

// } Driver Code Ends