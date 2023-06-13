//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int n, ArrayList<ArrayList<Integer>> graph) {
        // code here
        boolean[] visited = new boolean[n];
        boolean[] path_visited = new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                if(dfs(graph, i, visited, path_visited))
                    return true;
            }
        }
        return(false);
    }
    public static boolean dfs(ArrayList<ArrayList<Integer>> graph, int index, boolean[] visited, boolean[] path_visited){
        visited[index] = true;
        path_visited[index] = true;
        for(int it: graph.get(index)){
            if(!visited[it]){
                if(dfs(graph, it, visited, path_visited))
                    return true;
            }
            else if(path_visited[it])
                return true;
        }
        path_visited[index] = false;
        return false;
    }
}