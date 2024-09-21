//{ Driver Code Starts


import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static PrintWriter ot;

    public static void main(String args[]) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String s[] = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            List<List<int[]>> list = new ArrayList<>();
            for (int i = 0; i < V; i++) list.add(new ArrayList<>());
            for (int i = 0; i < E; i++) {
                s = br.readLine().trim().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                int c = Integer.parseInt(s[2]);
                list.get(a).add(new int[] {b, c});
                list.get(b).add(new int[] {a, c});
            }
            ot.println(new Solution().spanningTree(V, E, list));
        }
        ot.close();
    }
}
// } Driver Code Ends


// User function Template for Java
class Pair{
    int distance ;
    int node ;
    Pair(int x ,int y){
        this.distance = x;
        this.node = y;
    }
}
class Solution {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>(){
            public int compare(Pair a, Pair b) {  
               
                return Integer.compare(a.distance, b.distance); 
            }              
        });
        
        boolean vis[] = new boolean[V];
        
        pq.add(new Pair(0,0));
        int sum = 0;
        while(!pq.isEmpty()){
            int wt = pq.peek().distance;
            int node = pq.peek().node;
            pq.remove();
            if(vis[node]) continue;
            sum+= wt;
            vis[node] = true;
            
            for(int i = 0;i< adj.get(node).size();i++){
                int temp[] = adj.get(node).get(i);
                
                pq.add(new Pair(temp[1],temp[0]));
            }
           
        }
        
        
        return sum;
    }
}