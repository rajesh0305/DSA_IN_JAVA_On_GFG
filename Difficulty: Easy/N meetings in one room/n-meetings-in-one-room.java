//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) end[i] = Integer.parseInt(inputLine[i]);

            int ans = new Solution().maxMeetings(n, start, end);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends

class data{
    int start;
    int end;
    int pos;
    data(int start,int end,int pos){
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}
class meetingComparator implements Comparator<data>
{
    @Override
    public int compare(data o1, data o2) 
    {
        if (o1.end < o2.end)
            return -1;
        else if (o1.end > o2.end)
            return 1;
        else if(o1.pos < o2.pos)
            return -1;
        return 1; 
    }
}
class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public int maxMeetings(int n, int start[], int end[]) {
        // add your code here
      ArrayList<data> meet = new ArrayList<>();
        
        for(int i = 0; i < start.length; i++)
            meet.add(new data(start[i], end[i], i+1));
        
        meetingComparator mc = new meetingComparator(); 
        Collections.sort(meet, mc); 
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(meet.get(0).pos);
        int limit = meet.get(0).end; 
        int count = 1;
        for(int i = 1;i<start.length;i++) {
            if(meet.get(i).start > limit) {
                count++;
                limit = meet.get(i).end; 
                answer.add(meet.get(i).pos);
            }
        }
        // System.out.println("The order in which the meetings will be performed is ");
        // for(int i = 0;i<answer.size(); i++) {
        //     System.out.print(answer.get(i) + " ");
        // }
          return count;
    } 
    }

