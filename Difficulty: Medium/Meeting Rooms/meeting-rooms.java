//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                String temp[] = br.readLine().trim().split(" ");
                arr[i][0] = Integer.parseInt(temp[0]);
                String x = temp[1];
                arr[i][1] = Integer.parseInt(x);
            }
            Solution obj = new Solution();
            boolean ans = obj.canAttend(arr);
            if (ans)
                System.out.println("true");
            else
                System.out.println("false");
        }
    }
}
// } Driver Code Ends

// import java.util.*;

class Pair {
    int startTime;
    int endTime;

    Pair(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
}

class Solution {
    static boolean canAttend(int[][] arr) {
        ArrayList<Pair> ans = new ArrayList<>();
        int row = arr.length;
        
        for (int i = 0; i < row; i++) {
            ans.add(new Pair(arr[i][0], arr[i][1]));
        }
        
        // Comparator sorting based on start time, then by end time
        Collections.sort(ans, (a, b) -> a.startTime != b.startTime ? a.startTime - b.startTime : a.endTime - b.endTime);
        
        for (int i = 1; i < ans.size(); i++) {
            // Check if there's an overlap
            if (ans.get(i).startTime < ans.get(i - 1).endTime) {
                return false;
            }
        }
        return true;
    }
}
