//{ Driver Code Starts
//Initial Template for Java



import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            Pair ans = new Solve().getFloorAndCeil(arr, n, x);
            System.out.println(ans.floor + " " + ans.ceil);
        }
    }
}

class Pair {
    int floor, ceil;

    Pair() {
        this.floor = 0;
        this.ceil = 0;
    }

    Pair(int floor, int ceil) {
        this.floor = floor;
        this.ceil = ceil;
    }
}

// } Driver Code Ends


//User function Template for Java




class Solve {
    public static int findmax(int arr[]){
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<arr.length;i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }
        return max;
    }
    public static int findmin(int arr[]){
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<arr.length;i++){
            if(arr[i]<min){
                min =arr[i];
            }
        }
        return min;
    }
    public static int findfloor(int arr[],int x){
        for(int i = 0;i<arr.length;i++){
            if(arr[i]==x){
                return arr[i];
            }
        }
        return -1;
    }
    public static int findceil(int arr[],int x){
        for(int i =0;i<arr.length;i++){
            if(arr[i]==x){
                return arr[i];
            }
        }
        return -1;
    }
    Pair getFloorAndCeil(int[] arr, int n, int x) {
        // code here
    //     int max = findmax(arr);
    //     int min = findmin(arr);
    //     int floorvalue = Math.abs(x-1);
    //     int ceilvalue = Math.abs(x+1);
    //     if(floorvalue<min && ceilvalue>max){
    //         return new Pair(-1,-1);
    //     }
    //   int floor = findfloor(arr,floorvalue);
    //   int ceil = findceil(arr,ceilvalue);
    //   return new Pair(floor,ceil);
        int floor = getFloor(arr,n,x);
        int ceil = getCeil(arr,n,x);
        
        return new Pair(floor,ceil);
    
    }
    
    int getFloor(int [] arr , int n , int x){
        
        int diff = Integer.MAX_VALUE;
        int res = -1;
        int prevDiff = diff;
        
        for(int i=0;i<n;i++){
            if(arr[i]<=x){
                diff=Math.abs(x-arr[i]);
                if(diff<prevDiff){
                    res=arr[i];
                    prevDiff=diff;
                }
            }
        }
        
        return res;
    
    }
    
    int getCeil(int [] arr , int n , int x){
        
        int diff = Integer.MAX_VALUE;
        int prevDiff = diff;
        int res = -1;
        for(int i=0;i<n;i++){
            if(arr[i]>=x){
                diff=Math.abs(x-arr[i]);
                if(diff<prevDiff){
                    res=arr[i];
                    prevDiff=diff;
                }
            }
        }
        
        return res;
    }
}

