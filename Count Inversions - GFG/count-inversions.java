//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];
            
            for(long i = 0; i < n; i++)
             arr[(int)i] = sc.nextLong();
             
            System.out.println(new Solution().inversionCount(arr, n));
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    static long inversionCount(long arr[], long N)
    {
        // Your Code Here
        long[] count = new long[1];
        merge_sort(arr, 0, arr.length-1, count);
        // System.out.println(" "+count[0]);
        return count[0];
    }
    public static void merge_sort(long[] arr, int l, int h, long[] count){
        if(l < h){
            int mid = (l + h)/2;
            merge_sort(arr, l, mid, count);
            merge_sort(arr, mid+1, h, count);
            merge(arr, l, mid, h, count);
        }
    }
    public static void merge(long[] arr, int l, int mid, int h, long[] count){
        int n1 = (mid - l + 1);
        int n2 = (h - mid);
        long[] left = new long[n1];
        long[] right = new long[n2];
        for(int i=0;i<n1;i++)
            left[i] = arr[l + i];
        for(int i=0;i<n2;i++)
            right[i] = arr[mid + 1 + i];
        int k = l, i = 0, j = 0;
        while(i < n1 && j < n2){
            if(left[i] <= right[j]){
                arr[k] = left[i];
                i++;
            }
            else {
                arr[k] = right[j];
                j++;
                count[0] += (n1 - i);
            }
            k++;
        }
        while(i < n1){
            arr[k] = left[i];
            i++;
            k++;
        }
        while(j < n2){
            arr[k] = right[j];
            j++;
            k++;
        }
    }
}