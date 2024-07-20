//{ Driver Code Starts
import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int r = sc.nextInt();
            int c = sc.nextInt();
            
            int matrix[][] = new int[r][c];
            
            for(int i = 0; i < r; i++)
            {
                for(int j = 0; j < c; j++)
                 matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix, r, c);
            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to return a list of integers denoting spiral traversal of matrix.
    static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c)
    {
        // code here 
     ArrayList<Integer> list=new ArrayList<>();
        int strow=0;
        int stcol=0;
        int endrow=r-1;
        int endcol=c-1;
        while(strow<=endrow && stcol<=endcol){
            for(int i=stcol;i<=endcol;i++){
                list.add(matrix[strow][i]);
            }
            for(int j=strow+1;j<=endrow;j++){
                list.add(matrix[j][endcol]);
            }
            for(int i=endcol-1;i>=strow;i--){
                if(strow==endrow){
                    break;
                }
                list.add(matrix[endrow][i]);
            }
            for(int j=endrow-1;j>=strow+1;j--){
                if(stcol==endcol){
                    break;
                }
                list.add(matrix[j][stcol]);
            }
            strow++;
            stcol++;
            endrow--;
            endcol--;
        }
        return list;
    }
}
