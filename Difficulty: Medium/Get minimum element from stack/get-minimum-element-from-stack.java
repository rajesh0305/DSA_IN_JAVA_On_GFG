//{ Driver Code Starts
import java.util.*;



class Get_Min_From_Stack
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T>0)
		{
			int q = sc.nextInt();
			GfG g = new GfG();
			while(q>0)
			{
				int qt = sc.nextInt();
				
				if(qt == 1)
				{
					int att = sc.nextInt();
					g.push(att);
					//System.out.println(att);
				}
				else if(qt == 2)
				{
					System.out.print(g.pop()+" ");
				}
				else if(qt == 3)
				{
					System.out.print(g.getMin()+" ");
				}
			
			q--;
			}
			System.out.println();
		T--;
		}
		
	}
}



// } Driver Code Ends


class GfG
{
    int minEle;
    Stack<Integer> s;
    
    // Constructor    
    GfG()
{
      s = new Stack<>();
}
 
    /*returns min element from stack*/
    int getMin()
    {
// Your code here
if(s.size()==0) return -1;
return minEle;
 
    }
    
    /*returns poped element from stack*/
    int pop()
    {
// Your code here
  if(s.size() == 0) return -1;
    
    if(s.peek() < minEle) {
        int y = minEle;
        minEle = 2 * minEle - s.peek();
        s.pop();
        return y;
    } 
    else {
        return s.pop();
    }
    }
 
    /*push element x into the stack*/
    void push(int x)
    {
// Your code here
if (s.isEmpty()) {
        minEle = x;
        s.push(x);
    } else if (x < minEle) {
        s.push(2 * x - minEle);
        minEle = x;
    } else {
        s.push(x);
    }
    }
}