//{ Driver Code Starts
import java.util.*;


class checkBinary
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		while(T>0)
		{
			String str = sc.nextLine();
			GfG g = new GfG();
			boolean b = g.isBinary(str);
			if(b== true)
				System.out.println(1);
			else
			    System.out.println(0);
		T--;
		}
	}
}


// } Driver Code Ends


class GfG
{
	boolean isBinary(String str)
	{
	  //Your code here
  if(str.length()==0){
	      return false;
	  } 	
	  int i = 0;
	  char arr[] = str.toCharArray();
	  while(i<arr.length){
	    if(arr[i]!='1' &&arr[i]!='0'){
	        return false;
	    }
	      i++;
	  }
	  return true;
	}
}