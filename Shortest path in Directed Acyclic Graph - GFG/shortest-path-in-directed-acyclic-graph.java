//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java
class Pair{
    int node;
    int weight;
    Pair(int node, int weight){
        this.node = node;
        this.weight = weight;
    }
}
class Solution {

	public int[] shortestPath(int n,int m, int[][] edges) {
		//Code here
		ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for(int i=0;i<=n;i++)
            graph.add(new ArrayList<>());
        for(int i=0;i<m;i++){
            Pair temp = new Pair(edges[i][1], edges[i][2]);
            graph.get(edges[i][0]).add(temp);
        }
        Stack<Integer> stk = new Stack<>();
        boolean[] visited = new boolean[n];
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;
        dfs(graph, stk, visited, 0);
        while(!stk.isEmpty()){
            int node = stk.pop();
            for(Pair it: graph.get(node))
                distance[it.node] = Math.min(distance[it.node], it.weight + distance[node]);
        }
        for(int i=0;i<n;i++)
            if(distance[i] == Integer.MAX_VALUE)
                distance[i] = -1;
        return distance;
    }
    public static void dfs(ArrayList<ArrayList<Pair>> graph, Stack<Integer> stk, boolean[] visited, int index){
        visited[index] = true;
        for(Pair it: graph.get(index)){
            if(!visited[it.node])
                dfs(graph, stk, visited, it.node);
        }
        stk.push(index);
    }
}