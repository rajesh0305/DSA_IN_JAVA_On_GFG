//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-- > 0){
            String S = sc.nextLine().trim();
            Solution ob = new Solution();
            if(ob.valid(S))
                System.out.println(1);
            else
                System.out.println(0);
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    boolean valid(String s) 
    { 
        // code here
           int len = s.length();
        Stack<Character> st = new Stack<>();
        
        for(int i=0; i<len; i++) {
            char ch = s.charAt(i);
            
            if(st.isEmpty() && (ch == ')' || ch == '}' || ch == ']')) {
                return false;
            } 
            
            if(ch == ')' || ch == '}' || ch == ']') {
               switch(ch) {
                    case ')':
                        if(st.peek() == '{' || st.peek() == '[') {
                            return false;
                        } else {
                            st.pop();
                        }
                        break;
                    case '}':
                        if(st.peek() == '(' || st.peek() == '[') {
                            return false;
                        } else {
                            st.pop();
                        }
                        break;
                    case ']':
                        if(st.peek() == '{' || st.peek() == '(') {
                            return false;
                        } else {
                            st.pop();
                        }
                        break;
                } 
            } else {
                st.push(ch);
            }
        }
        
        return st.isEmpty();

    }
} 