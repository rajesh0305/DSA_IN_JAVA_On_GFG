//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] grid = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution obj = new Solution();
            int ans = obj.MaxConnection(grid);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends

class DisjointSet{
    List<Integer> size = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    
    public DisjointSet(int n){
        for(int i=0;i<=n;i++){
            size.add(1);
            parent.add(i);
        }
    }
    
    public int findUParent(int node){
        if(node == parent.get(node))
            return node;
        int ulp = findUParent(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }
    
    public void UnionBySize(int u, int v){
        int ulp_u = findUParent(u);
        int ulp_v = findUParent(v);
        
        if(ulp_u == ulp_v)
            return;
        if(size.get(ulp_u)<size.get(ulp_v)){
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_u)+size.get(ulp_v));
        }
        else{
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u)+size.get(ulp_v));
        }
    }
}
class Solution {

    public int MaxConnection(int grid[][]) {
        // Your code 
            int n = grid.length;
        DisjointSet ds = new DisjointSet(n*n);
        
        //STEP 1
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0)
                    continue;
                int[] delrow = {-1, 0, +1, 0};
                int[] delcol = {0, +1, 0, -1};
                for(int k=0;k<4;k++){
                    int nrow = i + delrow[k];
                    int ncol = j + delcol[k];
                    if(nrow>=0 && nrow<n && ncol>=0 && ncol<n && grid[nrow][ncol]==1){
                        ds.UnionBySize(i*n + j, nrow*n + ncol);
                    }
                }
            }
        }
        
        //STEP 2
        int max = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1)
                    continue;
                int[] delrow = {-1, 0, +1, 0};
                int[] delcol = {0, +1, 0, -1};
                HashSet<Integer> hs = new HashSet<Integer>();
                for(int k=0;k<4;k++){
                    int nrow = i + delrow[k];
                    int ncol = j + delcol[k];
                    if(nrow>=0 && nrow<n && ncol>=0 && ncol<n && grid[nrow][ncol]==1){
                        hs.add(ds.findUParent(nrow*n + ncol));
                    }
                }
                int size = 0;
                for(Integer a : hs){
                    size += ds.size.get(a);
                }
                max = Math.max(max, size+1);
            }
        }
        for(int i=0;i<n*n;i++){
            max = Math.max(max, ds.size.get(ds.findUParent(i)));
        }
        return max;
    }
}