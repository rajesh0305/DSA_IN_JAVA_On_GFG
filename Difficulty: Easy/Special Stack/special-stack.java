//{ Driver Code Starts
import java.util.Scanner;
import java.util.Stack;
class SpeStack{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			Stack<Integer> s=new Stack<>();
			GfG g=new GfG();
			while(!g.isEmpty(s)){
			    g.pop(s);
			}
			while(!g.isFull(s,n)){
				g.push(sc.nextInt(),s);
			}
		System.out.println(g.min(s));
		}
	}
}
// } Driver Code Ends


/*Complete the function(s) below*/
class GfG{
	public void push(int a,Stack<Integer> s)
	{
	    //add code here.
	    s.push(a);
	    
	}
	public int pop(Stack<Integer> s)
        {
            //add code here.
            if(!s.isEmpty()){
                return -1;
            }
            return s.peek();
	}
	public int min(Stack<Integer> s)
        {
           //add code here.
           int min = Integer.MAX_VALUE;
          while(!s.isEmpty()){
              int ele = s.pop();
              if(ele<min){
                  min = ele;
              }
          }
          return min;
	}
	public boolean isFull(Stack<Integer>s, int n)
        {
           //add code here.
           if(s.size()==n){
               return true;
           }else{
               return false;
           }
	}
	public boolean isEmpty(Stack<Integer>s)
        {
           //add code here.
           if(s.isEmpty()==true){
               return true;
           }else{
               return false;
           }
	}
}