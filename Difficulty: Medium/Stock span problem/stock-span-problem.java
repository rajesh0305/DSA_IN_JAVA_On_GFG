//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends

class Solution {
    public static int checkPrevG(int arr[],int end,int ele){
      int i= end;
      while(i>=0){
          if(arr[i]>ele){
              return i;
          }
          i--;
      }
      return 0;
    }
    public static int[] bruteforce(int arr[],int n){
        int ans[] = new int [n];
        int k = 0;
          for(int i =0;i<n;i++){
              int ele = arr[i];
              int index = checkPrevG(arr,i,ele);
              if(index>=0){
                  int res = i-index;
                  ans[k++] = res;
              }
          }
          return ans;
    }
    // Function to calculate the span of stockâ€™s price for all n days.
    public static int[] calculateSpan(int price[], int n) {
        // Your code here
        //return bruteforce(price,n);
        Stack<Integer>s = new Stack<>();
        int ans[] = new int [n];
        ans[0] = 1;
        s.push(0);
        for(int x = 1;x<n;x++){
            while(!s.isEmpty()&& price[s.peek()]<=price[x]){
            s.pop();
            }
            if(s.isEmpty()){
                ans[x] = x+1;
            }else{
                ans[x] = x-s.peek();
            }
            s.push(x);
        }
        
        return ans;
    }
}

//{ Driver Code Starts.

class gfg {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];

            int i = 0;
            for (i = 0; i < n; i++) a[i] = sc.nextInt();

            int[] s = new Solution().calculateSpan(a, n);

            for (i = 0; i < n; i++) {
                System.out.print(s[i] + " ");
            }

            System.out.println();
        }
    }
}
// } Driver Code Ends