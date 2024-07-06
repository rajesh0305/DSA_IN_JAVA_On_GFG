//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            String str[] = read.readLine().trim().split("\\s+");
            int r = Integer.parseInt(str[0]);
            int c = Integer.parseInt(str[1]);
            int matrix[][] = new int[r][c];
            
            for(int i = 0; i < r; i++)
            {
                int k = 0;
                str = read.readLine().trim().split("\\s+");
                for(int j = 0; j < c; j++){
                  matrix[i][j] = Integer.parseInt(str[k]);
                  k++;
                }
            }
            Solution obj = new Solution();
            int[] p = obj.endPoints(matrix,r,c);
            System.out.print("(" +  p[0]+ ", " +  p[1]+ ")" +"\n");
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution{
    
   // static int [] endPoints(int [][]arr, int m, int n){
        // char dir = 'r';
        // int i = 0;
        // int j =0;
        // int ans[] = new int [2];
        // while(true){
        //     if(arr[i][j]==1){
        //         arr[i][j] = 0;
        //         if(dir=='u')dir = 'r';
        //         else if(dir=='r')dir = 'd';
        //         else if(dir=='d')dir = 'l';
        //         else dir = 'u';
        //     }
        //     if(dir=='r'){
        //         j++;
        //         if(j>=n)
        //         ans[0] =i;
        //         ans[1] = j-1;
        //         return ans;
        //     }else if(dir=='l'){
        //         j--;
        //         if(j<0)
        //             ans[0] =i;
        //             ans[1] = j+1;
        //           return ans;
        //     }else if(dir=='u'){
        //         i--;
        //         if(i<0)
        //             ans[0] = i+1;
        //             ans[1] = j;
        //             return ans;
        //     }else{
        //         i++;
        //         if(i>=m)
        //             ans[0] = i-1;
        //             ans[1] = j;
        //             return ans;
        //     }
        // }
        // //return ans;
        
        
        //Approach 2(recursive)
        static void solve(int[] ans, int[][] arr, int m, int n, int x, int y, char direction) {
        // base cases
        // moved out from right
        if(x < m && y == n) {
            ans[0] = x;
            ans[1] = y-1;
            return;
        }
        
        // moved out from down
        if(x == m && y < n) {
            ans[0] = x-1;
            ans[1] = y;
            return;
        }
        
        // moved out from left
        if(y < 0 && x >= 0 && x < m) {
            ans[0] = x;
            ans[1] = y+1;
            return;
        }
        
        // moved out from up 
        if(x < 0 && y >= 0 && y < n) {
            ans[0] = x+1;
            ans[1] = y;
            return;
        }
        
        int newX=0, newY=0;
        
        // if cell == 0, then just move in same direction
        if(arr[x][y] == 0) {
            if(direction == 'D') {
                newX = x+1;
                newY = y;
            } else if(direction == 'L') {
                newX = x;
                newY = y-1;
            } else if(direction == 'R') {
                newX = x;
                newY = y+1;
            } else {
                newX = x-1;
                newY = y;
            }
        } else {
            // if cell == 1, mark cell as 0, move in clockwise direction
            arr[x][y] = 0;
            if(direction == 'U') {
                direction = 'R';
                newX = x;
                newY = y+1;
            } else if(direction == 'R') {
                direction = 'D';
                newX = x+1;
                newY = y;
            } else if(direction == 'D') {
                direction = 'L';
                newX = x;
                newY = y-1;
            } else {
                direction = 'U';
                newX = x-1;
                newY = y;
            }
        }
        solve(ans, arr, m, n, newX, newY, direction);
    }
    
    static int [] endPoints(int [][]arr, int m, int n){
        int ans[] = new int[2];
        // initially standing at (0,0) cell and moving in 'R' direction
        solve(ans, arr, m, n, 0, 0, 'R');
        return ans;
    }
}