//{ Driver Code Starts
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());

        while (t-- > 0) {
            String line = scanner.nextLine();
            String[] tokens = line.split(" ");
            List<Integer> nums = new ArrayList<>();
            for (String token : tokens) {
                nums.add(Integer.parseInt(token));
            }

            Solution solution = new Solution();
            System.out.println(solution.pairWithMaxSum(nums));
        }

        scanner.close();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static void find_first_second_min1(ArrayList<Integer>arr,ArrayList<Integer>res){
         Collections.sort(arr);
        //  res.add(arr.get(0));
        //  res.add(arr.get(1));
        int sum =arr.get(0)+arr.get(1);
        res.add(sum);
    }
    public static void find_first_second_min2(ArrayList<Integer>arr,ArrayList<Integer>res){
           int first_min =Integer.MAX_VALUE;
           for(int i = 0;i<arr.size();i++){
               int ele = arr.get(i);
               if(first_min<ele){
                   first_min = ele;
               }
           }
           int second_min = Integer.MAX_VALUE;
           for(int i= 0;i<arr.size();i++){
               int ele =arr.get(i);
               if(ele>first_min && ele<second_min){
                   second_min = ele;
               }
           }
        //   res.add(first_min);
        //   res.add(decond_min);
         int sum = first_min+second_min;
         res.add(sum);
    }
    public static int find_max(ArrayList<Integer>arr){
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<arr.size();i++){
              int ele = arr.get(i);
              if(ele>max){
                  max = ele;
                  
              }
        }
        return max ;
    }
    public static int pairSum(List<Integer>arr){
        int max =0;
        for(int i = 0;i<arr.size()-1;i++){
            int sum =arr.get(i)+arr.get(i+1);
            max =Math.max(sum,max);
        }
        return max;
    }
    // Function to find pair with maximum sum
    public int pairWithMaxSum(List<Integer> arr) {
        // Your code goes here
        // ArrayList<Integer>res = new ArrayList<Integer>();
        // for(int i = 0;i<arr.size();i++){
        //     ArrayList<Integer>ans =new ArrayList<Integer>();
        //     ans.add(arr.get(i));
        //     for(int j = i+1;j<arr.size();j++){
        //         ans.add(arr.get(j));
        //         find_first_second_min2(ans,res);
        //     }
        // }
        // int max =find_max(res);
        return pairSum(arr);
    }
}