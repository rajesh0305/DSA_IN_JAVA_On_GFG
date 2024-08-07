//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            System.out.println(
                new Solution().infixToPostfix(br.readLine().trim()));
        }
    }
}
// } Driver Code Ends


class Solution {
    static int prec(char c) {
        if (c == '^')
            return 3;
        else if (c == '*' || c == '/')
            return 2;
        else if (c == '+' || c == '-')
            return 1;
        else
            return -1;
    }

         static char associativity(char c) {
        if (c == '^')
            return 'R';
        return 'L'; // Default to left-associative
    }
    
    // Function to convert an infix expression to a postfix expression.
        public static String infixToPostfix(String s) {
        // Your code here
        StringBuilder result = new StringBuilder();  // String result = "";
        Stack<Character> st = new Stack<>();
        
      for(int i =0 ; i<s.length(); i++){
          
          char c= s.charAt(i);
          
          if(c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z' || c >= '0' && c <= '9'){
              result.append(c);  // result = result + c;
          }
          else if(c == '('){
              st.push(c);
          }else if(c == ')'){
              while(!st.isEmpty() && st.peek()!= '('){
                 result.append(st.pop()); // result = result + st.pop();
              }
              st.pop();
          }
          else{
              while(!st.isEmpty() && prec(s.charAt(i)) <= prec(st.peek())){
                  result.append(st.pop());  // result += st.pop();
              }
              st.push(c);
          }
        
      }
      while(!st.isEmpty()){
          result.append(st.pop());  // result += st.pop;
      }
      return result.toString();
    }
}