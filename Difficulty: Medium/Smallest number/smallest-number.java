//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-- > 0) {
            int s = sc.nextInt();
            int d = sc.nextInt();

            Solution obj = new Solution();
            String res = obj.smallestNumber(s, d);

            System.out.println(res);
        }
    }
}
// } Driver Code Ends



class Solution {

    public String smallestNumber(int s, int d) {
        // code here
        if(s>9*d){
            return "-1";
        }
    //     String st = "";
    //     for(int i = d-1;i>=0;i--){
    //         for(int j = 9;j>=0;j--){
    //                 if(i != 0){
    //                 if(s - j > 0){
    //                     st += j +'0';
    //                     s = s-j;
    //                     break;
    //                 }else{
    //                 st += s +'0';
    //                 break;
    //             }
    //         }
    //     }
    // }
    s = s-1;
    String st = "";
    for(int i =d-1;i>=0;i--){
        if(s>9){
            st = st+9;
            s = s-9;
        }else if(s<=9 && i>0){
                st = st+s;
                s = 0;
            }else{
                st = st+(s+1);
            }
    }
       StringBuilder sb = new StringBuilder(st);
      
      return ""+sb.reverse();
        }
    }
