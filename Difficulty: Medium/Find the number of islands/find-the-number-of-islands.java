//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt(); // Number of test cases
        while (tc-- > 0) {
            int n = scanner.nextInt(); // Number of rows
            int m = scanner.nextInt(); // Number of columns
            char[][] grid = new char[n][m];

            // Read the grid input
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = scanner.next().charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
        scanner.close();
    }
}

// } Driver Code Ends

class pair{
    int x,y;
    pair(int x,int y){
        this.x=x;
        this.y=y;
    }
}
class Solution {
      
    public int numIslands(char[][] grid) {
        // Code here
          // Code here
              int dp[][]=new int[grid.length][grid[0].length];
        Queue<pair> que=new LinkedList<>();
        int count=0;
        
      for(int i=0;i<grid.length;i++){
          for(int j=0;j<grid[0].length;j++){
              
              if(dp[i][j]==0 && grid[i][j]=='1'){
                  pair temp=new pair(i,j);
                  que.add(temp);
                  count++;
              }
              while(!que.isEmpty()){
                  
                  pair a=que.poll();
                  int x=a.x;
                  int y=a.y;
                  if(y+1<grid[0].length && grid[x][y+1]=='1' && dp[x][y+1]==0){
                      dp[x][y+1]=1;
                     a=new pair(x,y+1);
                      que.add(a);
                  }
                  if(y+1<grid[0].length  && x+1<grid.length && grid[x+1][y+1]=='1' && dp[x+1][y+1]==0){
                      dp[x+1][y+1]=1;
                     a=new pair(x+1,y+1);
                      que.add(a);
                  }
                  if(x+1<grid.length && grid[x+1][y]=='1' && dp[x+1][y]==0){
                      dp[x+1][y]=1;
                     a=new pair(x+1,y);
                      que.add(a);
                  }
                  if(x+1<grid.length && y-1>=0 && grid[x+1][y-1]=='1' && dp[x+1][y-1]==0){
                      dp[x+1][y-1]=1;
                     a=new pair(x+1,y-1);
                      que.add(a);
                  }
                  if( y-1>=0 && grid[x][y-1]=='1' && dp[x][y-1]==0){
                      dp[x][y-1]=1;
                     a=new pair(x,y-1);
                      que.add(a);
                  }
                  if(x-1>=0  && grid[x-1][y]=='1' && dp[x-1][y]==0){
                      dp[x-1][y]=1;
                     a=new pair(x-1,y);
                      que.add(a);
                  }
                  if(x-1>=0 && y-1>=0 && grid[x-1][y-1]=='1' && dp[x-1][y-1]==0){
                      dp[x-1][y-1]=1;
                     a=new pair(x-1,y-1);
                      que.add(a);
                  }
                  if(x-1>=0 && y+1<grid[0].length && grid[x-1][y+1]=='1' && dp[x-1][y+1]==0){
                      dp[x-1][y+1]=1;
                     a=new pair(x-1,y+1);
                      que.add(a);
                  }
              }
             
          }
      }
      return count;
    }
}