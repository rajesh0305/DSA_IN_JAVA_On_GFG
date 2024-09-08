//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            String[] arr = br.readLine().trim().split(" ");

            String ans = new Solution().printLargest(n, arr);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public static String help(String nums[]){
         Arrays.sort(nums,new Comparator<String>(){
            @Override
            public int compare(String a,String b){
                String str1=a+b;
                String str2=b+a;
                return str2.compareTo(str1);
            }
        }
        );
        
        if(nums[0].equals("0")){
            return "0";
        }
        StringBuilder sb=new StringBuilder();
        
        for(String num:nums){
            sb.append(num);
        }
        return sb.toString();
    }
    String printLargest(int n, String[] arr) {
        // code here
    //     Arrays.sort(arr,(a,b)->{
    //         Long n1 = Long.parseLong(a+b);
    //         Long n2 = Long.parseLong(b+a);
    //         if(n1>n2){
    //             return 1;
    //         }else if(n1<n2){
    //             return -1;
    //         }else{
    //             return 0;
    //         }
    //     });
    //   // String ans ="";
    //   StringBuilder sb =new StringBuilder("");
    //     int i = arr.length-1;
    //     while(i>=0){
    //           String inter = arr[i];
    //           //ans =ans+inter;
    //           sb.append(inter);
    //           i--;
    //     }
    // //    return ans;
    // return sb.toString();
    return help(arr);
    }
}