//{ Driver Code Starts
import java.util.*;

class FindMinCost
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int arr[][] = new int[n][m];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(new Solution().maxArea(arr, n, m));
		t--;
		}
	}
}
// } Driver Code Ends


/*Complete the function given below*/
class Solution {
       public int[] prevSmaller(int heights[]){
        int leftAns[] = new int[heights.length];
        Stack <Integer> st = new Stack<>();
        for(int i = 0; i < heights.length; i++){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                leftAns[i] = -1;
            }else{
                leftAns[i] = st.peek();
            }
            st.push(i);
        }
        return leftAns;
    }
    public int[] nextSmaller(int heights[]){
        Stack <Integer> st = new Stack<>();
        int rightAns[] = new int[heights.length];
        for(int i = heights.length-1; i >= 0 ; i--){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                rightAns[i] = heights.length;
            }else{
                rightAns[i] = st.peek();
            }
            st.push(i);
            
        }
        return rightAns;
    }
    public int largestRectangleArea(int[] heights) {
       int left[] = prevSmaller(heights);
       int right[] = nextSmaller(heights);
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < heights.length; i++){
           int area =  (right[i] - left[i] - 1) * heights[i];
            ans = Math.max(ans, area);
        }
        return ans;
    }
    public int maxArea(int M[][], int n, int m) {
        // add code here.
        int currRow[] = M[0];
        int maxans = largestRectangleArea(currRow);
        for(int i = 1;i<M.length;i++){
            for(int j =0;j<M[0].length;j++){
                if(M[i][j]==1){
                    currRow[j]=currRow[j]+1;
                }else{
                    currRow[j] =0;
                }
            }
            int currmax = largestRectangleArea(currRow);
            maxans = Math.max(maxans,currmax);
        }
        return maxans;
    }
}