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
            String[] S1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            int[][] image =  new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S2 = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    image[i][j] = Integer.parseInt(S2[j]);
            }
            String[] S3 = br.readLine().trim().split(" ");
            int sr = Integer.parseInt(S3[0]);
            int sc = Integer.parseInt(S3[1]);
            int newColor = Integer.parseInt(S3[2]);
            Solution obj = new Solution();
            int[][] ans = obj.floodFill(image, sr, sc, newColor);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++)
                    System.out.print(ans[i][j] + " ");
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends


class Solution{
    public int[][] floodFill(int[][] img, int sr, int sc, int nc){
        int n = img.length,m = img[0].length,ic = img[sr][sc];
        boolean vis[][] = new boolean[n][m];
        solve(sr,sc,n,m,ic,nc,img,vis);
        return img;
    }
    static void solve(int r,int c,int n,int m,int ic,int nc,int img[][],boolean vis[][]){
        if(r>=n || c>=m || r<0 || c<0) return;
        if(vis[r][c] || img[r][c]!=ic) return;
        vis[r][c] = true;
        img[r][c] = nc;
        solve(r-1,c,n,m,ic,nc,img,vis); //up
        solve(r+1,c,n,m,ic,nc,img,vis); //down
        solve(r,c+1,n,m,ic,nc,img,vis); //right
        solve(r,c-1,n,m,ic,nc,img,vis); //left
    }
}