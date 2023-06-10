//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int countDistinctIslands(int[][] grid) {
        // Your Code here
        int n = grid.length;
        int m = grid[0].length;
        HashSet<ArrayList<String>> store = new HashSet<>();
        boolean[][] visited = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1 && !visited[i][j]) {
                    ArrayList<String> vec = new ArrayList<>();
                    dfs(grid, visited, vec, i, j, i, j);
                    store.add(vec);
                }
            }
        }
        return(store.size());
    }
    public static void dfs(int[][] grid, boolean[][] visited, ArrayList<String> vec, int row, int col, int row0, int col0){
        visited[row][col] = true;
        vec.add(toString(row - row0, col - col0));
        int n = grid.length;
        int m = grid[0].length;
        for(int i=-1;i<=1;i++){
            for(int j=-1;j<=1;j++){
                int nrow = row + i;
                int ncol = col + j;
                if((i == 0 || j == 0) && nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && !visited[nrow][ncol] && grid[nrow][ncol] == 1){
                    dfs(grid, visited, vec, nrow, ncol, row0, col0);
                }
            }
        }
    }
    public static String toString(int n1, int n2){
        return String.valueOf(n1)+" "+String.valueOf(n2);
    }
}
