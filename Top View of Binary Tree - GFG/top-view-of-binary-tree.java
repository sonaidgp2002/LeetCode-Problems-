//{ Driver Code Starts
//Initial Template for JAVA

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

public class Tree {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
    	    	
                Solution ob = new Solution();

                ArrayList<Integer> vec = ob.topView(root);
                for(int x : vec)
                    System.out.print(x + " ");
                System.out.println();
        	
                t--;   
        }
    }
}
// } Driver Code Ends


//User function Template for Java

/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Tuple{
    Node n;
    int row;
    int col;
    Tuple(Node n, int row, int col)
    {
        this.n = n;
        this.row = row;
        this.col = col;
    }
}

class Solution
{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root1)
    {
        // add your code
        Queue<Tuple> q = new LinkedList<>();
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> hash = new TreeMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        q.add(new Tuple(root1, 0, 0));
        while(q.size() > 0)
        {
            int size = q.size();
            for(int i=0;i<size;i++)
            {
                Tuple t = q.poll();
                if(t.n.left != null)
                    q.offer(new Tuple(t.n.left, t.row+1, t.col-1));
                if(t.n.right != null)
                    q.offer(new Tuple(t.n.right, t.row+1, t.col+1));
                if(!hash.containsKey(t.col))
                    hash.put(t.col, new TreeMap<>());
                if(!hash.get(t.col).containsKey(t.row))
                    hash.get(t.col).put(t.row, new PriorityQueue<>());
                hash.get(t.col).get(t.row).offer(t.n.data);
            }
        }
        Iterator<Integer> itr = hash.keySet().iterator();
        while(itr.hasNext())
        {
            int key = itr.next();
            
            Iterator<Integer> itr1 = hash.get(key).keySet().iterator();
            while(itr1.hasNext())
            {
                int key1 = itr1.next();
                res.add(hash.get(key).get(key1).poll());
                break;
            }
        }
        return (res);
    }
}