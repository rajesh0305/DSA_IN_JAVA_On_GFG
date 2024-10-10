//{ Driver Code Starts
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


// } Driver Code Ends

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
class Solution {
    public List<Integer> rearrange(List<Integer> arr) {
        // Code here
     int n = arr.size();
    // Initialize the list 'ans' with 'n' elements, all set to -1
    List<Integer> ans = new ArrayList<>(Collections.nCopies(n, -1));

    // Now, go through the original array and place the positive elements in the correct positions
    for(int i = 0; i < n; i++) {
        if(arr.get(i) >= 0) {
            int pos = arr.get(i);
            if(pos < n) {
                ans.set(pos, arr.get(i));  // Use 'set' instead of 'add' to modify an existing index
            }
        }
    }
    return ans;
        //  for(int i = 0;i<arr.size();i++){
        //     // int ele =arr.get(i);
        //      if(arr.contains(i)){
        //          ans.add(i);
        //      }else{
        //          ans.add(-1);
        //      }
        //  }
        //  return arr;
    }
}

//{ Driver Code Starts.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Solution solution = new Solution();

        while (t-- > 0) {
            String input = scanner.nextLine();
            String[] inputArr = input.split("\\s+");
            List<Integer> arr = new ArrayList<>();
            for (String s : inputArr) {
                arr.add(Integer.parseInt(s));
            }

            List<Integer> ans = solution.rearrange(arr);

            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
// } Driver Code Ends