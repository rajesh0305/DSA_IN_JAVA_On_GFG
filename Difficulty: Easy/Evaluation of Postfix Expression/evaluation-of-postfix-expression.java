//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    System.out.println(new Solution().evaluatePostFix(br.readLine().trim()));
		}
	}
}
// } Driver Code Ends



class Solution
{
 
    //Function to evaluate a postfix expression.
    public static int evaluatePostFix(String S)
    {
        // Your code here
      Stack<Integer> stack = new Stack<>();
        
        for(char s : S.toCharArray()){
            int ans = 0;
            if(s>='0' && s<='9'){
                int num = s - '0';
                stack.push(num);
            }   
            else{
                int num1 = stack.peek();
                stack.pop();
                int num2 = stack.peek();
                stack.pop();
                
                switch(s){
                    case '+':
                        ans = num2+num1;
                        stack.push(ans);
                        break;
                    case '*':
                        ans = num2*num1;
                        stack.push(ans);
                        break;
                    case '-':
                        ans = num2-num1;
                        stack.push(ans);
                        break;
                    case '/':
                        ans = num2/num1;
                        stack.push(ans);
                        break;
                }
               
            }
             
        }
       return stack.peek(); 
    }
}