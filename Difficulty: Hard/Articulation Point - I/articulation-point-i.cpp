//{ Driver Code Starts
//Initial Template for C++

#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
//User function Template for C++

class Solution {
    private:
      int timer;
    
    void dfs(int node, int parent, vector<int> adj[], vector<int> &dis, vector<int> &low,
             vector<int> &vis, vector<int> &Apoints, vector<bool> &isArticulation) {
        vis[node] = 1;
        dis[node] = low[node] = timer++;
        int child = 0;
        
        for (const auto &it : adj[node]) {
            if (it == parent) continue;
            if (!vis[it]) {
                child++;
                dfs(it, node, adj, dis, low, vis, Apoints, isArticulation);
                low[node] = min(low[node], low[it]);
                
                if (low[it] >= dis[node] && parent != -1 && !isArticulation[node]) {
                    Apoints.push_back(node);
                    isArticulation[node] = true;
                }
            } else {
                low[node] = min(low[node], dis[it]);
            }
        }

        if (parent == -1 && child > 1 && !isArticulation[node]) {
            Apoints.push_back(node);
            isArticulation[node] = true;
        }
    }
  public:
    vector<int> articulationPoints(int V, vector<int>adj[]) {
        // Code here
         timer = 0;
        vector<int> dis(V, -1), low(V, -1), vis(V, 0);
        
        vector<int> Apoints;
        vector<bool> isArticulation(V, false);
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(i, -1, adj, dis, low, vis, Apoints, isArticulation);
            }
        }
        
        if (Apoints.empty()) {
            return {-1};
        }

        sort(Apoints.begin(), Apoints.end()); 
        return Apoints;
    }
};

//{ Driver Code Starts.

int main(){
	int tc;
	cin >> tc;
	while(tc--){
		int V, E;
		cin >> V >> E;
		vector<int>adj[V];
		for(int i = 0; i < E; i++){
			int u, v;
			cin >> u >> v;
			adj[u].push_back(v);
			adj[v].push_back(u);
		}
		Solution obj;
		vector<int> ans = obj.articulationPoints(V, adj);
		for(auto i: ans)cout << i << " ";
		cout << "\n";
	
cout << "~" << "\n";
}
	return 0;
}
// } Driver Code Ends