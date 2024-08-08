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
            int N = Integer.parseInt(br.readLine().trim());
            String[] S1 = br.readLine().trim().split(" ");
            String[] S2 = br.readLine().trim().split(" ");
            int[] KnightPos = new int[2];
            int[] TargetPos = new int[2];
            for(int i = 0; i < 2; i++){
                KnightPos[i] = Integer.parseInt(S1[i]);
                TargetPos[i] = Integer.parseInt(S2[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minStepToReachTarget(KnightPos, TargetPos, N);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends


class Solution
{
    //Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
        // Code here
         boolean[][] vis = new boolean[N + 1][N + 1];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{KnightPos[0], KnightPos[1], 0});
        int[] dx = {-1, -1, 1, 1, -2, -2, 2, 2};
        int[] dy = {2, -2, 2, -2, -1, 1, 1, -1};
        int min = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int x = queue.peek()[0];
            int y = queue.peek()[1];
            int steps = queue.peek()[2];
            if (x == TargetPos[0] && y == TargetPos[1]) {
                min = Math.min(min, steps);
            }
            for (int i = 0; i < 8; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (newX >= 1 && newY >= 1 && newX <= N && newY <= N && !vis[newX][newY]) {
                    queue.add(new int[]{newX, newY, steps + 1});
                    vis[newX][newY] = true;
                }
            }
            queue.poll();
        }
        return min;
    }
}