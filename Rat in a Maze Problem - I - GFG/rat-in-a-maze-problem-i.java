//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        ArrayList<String> res = new ArrayList<>();
        if(m[0][0] == 0)
            return res;
        boolean[][] visited = new boolean[n][n];
        int[] di = {1, 0, 0, -1};
        int[] dj = {0, -1, 1, 0};
        find(m, n, visited, res, "", di, dj, 0, 0);
        return res;
    }
    public static void find(int[][] m, int n, boolean[][] visited, ArrayList<String> res, String s, int[] di, int[] dj, int i, int j){
        if(i == n-1 && j == n-1){
            res.add(s);
            return;
        }
        String t = "DLRU";
        for(int k=0;k<4;k++){
            int ni = i + di[k];
            int nj = j + dj[k];
            if(ni >= 0 && ni < n && nj >= 0 && nj < n && !visited[ni][nj] && m[ni][nj] == 1){
                visited[i][j] = true;
                find(m, n, visited, res, s + t.charAt(k), di, dj, ni, nj);
                visited[i][j] = false;
            }
        }
    }
}