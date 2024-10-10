//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


class Pair{
    int first;
    int second;
     Pair(int first,int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public static boolean checkforcycle(int scr,int V,ArrayList<ArrayList<Integer>>adj,boolean vis[]){
        vis[scr] = true;
        Queue<Pair>q = new LinkedList<>();
        q.add(new Pair(scr,-1));
        
        while(!q.isEmpty()){
            int node =q.peek().first;
            int parentnode = q.peek().second;
            q.remove();
            
            for(int adjacentnode:adj.get(node)){
                if(vis[adjacentnode]==false){
                    vis[adjacentnode]=true;
                    q.add(new Pair(adjacentnode,node));
                }else if(parentnode!=adjacentnode){
                    return true;
                }
            }
        }
        return false;
    }
  
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean vis[] = new boolean[V];
        for(int i = 0;i<V;i++){
            vis[i] = false;
        }
     for(int i = 0;i<V;i++){
         if(vis[i]==false){
             if(checkforcycle(i,V,adj,vis)){
                 return true;
             }
         }
     }
     return false;
    }
}