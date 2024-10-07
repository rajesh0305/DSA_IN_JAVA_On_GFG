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
   public static void bfs(int ro,int co,int visited[][],char grid[][]){
       int n = grid.length;
       int m = grid[0].length;
       visited[ro][co] = 1;
       Queue<pair>q = new LinkedList<>();
       while(!q.isEmpty()){
           int row = q.peek().x;
           int col = q.peek().y;
           
           for(int delRow =-1;delRow<=1;delRow++){
               for(int delcol =-1;delcol<=1;delcol++){
                    int nrow = row+delRow;
                    int ncol = col+delcol;
                    if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]=='1' && visited[nrow][ncol]==0){
                        visited[nrow][ncol] = 1;
                        q.add(new pair(nrow,ncol));
                        
                    }
               }
           }
       }
       
   }   
    public int numIslands(char[][] grid) {
        // Code here
          // Code here
       int dp[][]=new int[grid.length][grid[0].length];
        Queue<pair> que=new LinkedList<>();
        int count=0;
        int n = grid.length;
        int m = grid[0].length;
      for(int i=0;i<grid.length;i++){
          for(int j=0;j<grid[0].length;j++){
              if(dp[i][j]==0 && grid[i][j]=='1'){
                  pair temp=new pair(i,j);
                  que.add(temp);
                  count++;
                //   bfs(n,m,dp,grid);
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
