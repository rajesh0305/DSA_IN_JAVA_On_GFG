//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java
class Solution {

	public int[] shortestPath(int N,int M, int[][] edges) {
		//Code here
		ArrayList<ArrayList<Pair>>  adj = new ArrayList<>();
for(int i=0;i<N;i++){
    adj.add(new ArrayList<>());
}
for(int i=0;i<M;i++){
    int u = edges[i][0];
    int v = edges[i][1];
    int d=edges[i][2];
    adj.get(u).add(new Pair(v,d));
}
int[] res = new int[N];
Arrays.fill(res,Integer.MAX_VALUE);
res[0]=0;
 
Queue<Pair> q=  new LinkedList<>();
q.add(new Pair(0,0));
while(!q.isEmpty()){
    int node = q.peek().node;
    int dist = q.peek().dist;
    q.poll();
    for(Pair j:adj.get(node)){
        int d = dist+j.dist;
        int ind = j.node;
        if(d<res[ind]){
            res[ind]=d;
            q.add(new Pair(ind,d));
        }
        
    }
}
for(int i=0;i<N;i++){
    if(res[i]==Integer.MAX_VALUE){
        res[i]=-1;
    }
}
return res;
}
}
class Pair{
    int node;
    int dist;
    public Pair(int node,int dist){
        this.node = node;
        this.dist=dist;
	}
}