//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java
class Solution {
     public static int findIndex(int[] arr, int value, int start) {
        for (int i = start; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }
    public List<List<Integer>> findTriplets(int[] arr) {
        // Your code here
  Set<ArrayList<Integer>> resSet = new HashSet<>();
        int n = arr.length;
        Map<Integer, List<int[]>> mp = new HashMap<>();

        // Store sum of all the pairs with their indices
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                mp.computeIfAbsent(arr[i] + arr[j], 
                              k -> new ArrayList<>()).add(new int[]{i, j});
            }
        }

        for (int i = 0; i < n; i++) {
            
            // Find remaining value to get zero sum
            int rem = -arr[i];
            if (mp.containsKey(rem)) {
                List<int[]> pairs = mp.get(rem);
                for (int[] p : pairs) {
                    
                    // Ensure no two indices are same in triplet
                    if (p[0] != i && p[1] != i) {
                        ArrayList<Integer> curr = 
                          new ArrayList<>(Arrays.asList(i, p[0], p[1]));
                        Collections.sort(curr);
                        resSet.add(curr);
                    }
                }
            }
        }
        return new ArrayList<>(resSet);  
    }
    }


//{ Driver Code Starts.

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String line = read.readLine().trim();
            String[] numsStr = line.split(" ");
            int[] nums = new int[numsStr.length];
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            Solution obj = new Solution();
            List<List<Integer>> res = obj.findTriplets(nums);
            Collections.sort(res, (a, b) -> {
                for (int i = 0; i < a.size(); i++) {
                    if (!a.get(i).equals(b.get(i))) {
                        return a.get(i) - b.get(i);
                    }
                }
                return 0;
            });
            if (res.size() == 0) {
                System.out.println("[]");
            }
            for (int i = 0; i < res.size(); i++) {
                for (int j = 0; j < res.get(i).size(); j++) {
                    System.out.print(res.get(i).get(j) + " ");
                }
                System.out.println();
            }
            System.out.println("~");
        }
    }
}
// } Driver Code Ends