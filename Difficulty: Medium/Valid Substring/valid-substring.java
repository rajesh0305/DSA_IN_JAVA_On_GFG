//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.findMaxLen(S));
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    static int findMaxLen(String S) {
        // code here
           int size = S.length();
        Stack<Integer> stack = new Stack<>();  // To store indices of '(' characters
        int maxLength = 0;

        // Traverse through the string
        for (int i = 0; i < size; i++) {
            char ch = S.charAt(i);

            if (ch == '(') {
                stack.push(i);  // Push the index of '(' character onto the stack
            } else {
                // If stack is empty or the current ')' character matches a corresponding '('
                if (!stack.isEmpty() && S.charAt(stack.peek()) == '(') {
                    stack.pop();  // Pop the matching '(' index from the stack
                    int start = stack.isEmpty() ? -1 : stack.peek();  // Index of last unmatched '('
                    maxLength = Math.max(maxLength, i - start);  // Calculate the valid substring length
                } else {
                    stack.push(i);  // Push the index of ')' character onto the stack
                }
            }
        }

        return maxLength;
    }
};