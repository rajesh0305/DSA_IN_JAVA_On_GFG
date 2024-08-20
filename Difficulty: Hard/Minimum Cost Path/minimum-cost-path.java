//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.minimumCostPath(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// class Solution
// {
//     //Function to return the minimum cost to react at bottom
	//right cell from top left cell.
//     public int minimumCostPath(int[][] grid)
//     {

//       int dp[][] = new int [grid.length][grid[0].length];
//       for(int i =grid.length-1;i>=0;i--){
//           for(int j = grid[0].length-1;j>=0;j--){
//               if(i==dp.length-1 && j==dp[0].length-1){
//                   dp[i][j] =grid[i][j];
//               }else if(i==dp.length-1){
//                   dp[i][j] = grid[i][j]+dp[i][j+1];
//               }else if(j==dp[0].length-1){
//                   dp[i][j] = grid[i][j]+dp[i+1][j];
//               }else{
//                   dp[i][j] =grid[i][j]+Math.min(dp[i+1][j],dp[i][j+1]);
//               }
//           }
//       }
//         return dp[0][0];
//     }
// }
class Solution{
    class pair{
        int r,c; //vertex in form of (a,b) cartesian point
        int weight;
        pair(int r,int c,int weight){
            this.r=r;
            this.c=c;
            this.weight=weight;
        }
    }
    
    public int minimumCostPath(int[][] grid){
        int r=grid.length,c=grid[0].length;
        PriorityQueue<pair> pq=new PriorityQueue<pair>((a,b)->a.weight-b.weight);
        int[][] dist=new int[r][c];
        
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                dist[i][j]=Integer.MAX_VALUE;
            }
        }
        pq.add(new pair(0,0,grid[0][0]));
        dist[0][0]=grid[0][0];
        
        int[] dx={-1,1,0,0};
        int[] dy={0,0,1,-1};
        
        while(!pq.isEmpty()){
            pair curr=pq.poll();
            int r1=curr.r,c1=curr.c,w=curr.weight;
            
            for(int i=0;i<4;i++){
                int x=r1+dx[i];
                int y=c1+dy[i];
                if(x>=0 && y>=0 && x<r && y<c){
                    if(dist[x][y]>dist[r1][c1]+grid[x][y]){
                        dist[x][y]=dist[r1][c1]+grid[x][y];
                        pq.add(new pair(x,y,dist[x][y]));
                    }
                }
            }
        }
return dist[r-1][c-1];
}
}
