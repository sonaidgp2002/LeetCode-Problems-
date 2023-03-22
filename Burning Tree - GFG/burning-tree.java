//{ Driver Code Starts
//Initial Template for Java


import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
	int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

class GfG {

	static Node buildTree(String str) {

		if (str.length() == 0 || str.charAt(0) == 'N') {
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
		while (queue.size() > 0 && i < ip.length) {

			// Get and remove the front of the queue
			Node currNode = queue.peek();
			queue.remove();

			// Get the current node's value from the string
			String currVal = ip[i];

			// If the left child is not null
			if (!currVal.equals("N")) {

				// Create the left child for the current node
				currNode.left = new Node(Integer.parseInt(currVal));
				// Push it to the queue
				queue.add(currNode.left);
			}

			// For the right child
			i++;
			if (i >= ip.length)
				break;

			currVal = ip[i];

			// If the right child is not null
			if (!currVal.equals("N")) {

				// Create the right child for the current node
				currNode.right = new Node(Integer.parseInt(currVal));

				// Push it to the queue
				queue.add(currNode.right);
			}
			i++;
		}

		return root;
	}

	static void printInorder(Node root) {
		if (root == null)
			return;

		printInorder(root.left);
		System.out.print(root.data + " ");

		printInorder(root.right);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t > 0) {
			String s = br.readLine();
			int target = Integer.parseInt(br.readLine());
			Node root = buildTree(s);

			Solution g = new Solution();
			System.out.println(g.minTime(root, target));
			t--;

		}
	}
}



// } Driver Code Ends


//User function Template for Java

class Solution
{
    /*class Node {
    	int data;
    	Node left;
    	Node right;
    
    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }*/
    
    public static int minTime(Node root, int target) 
    {
        // Your code goes here
        Node targ = find_target(root, target);
        Queue<Node> q = new LinkedList<>();
        HashMap<Node, Node> hash = new HashMap<>();
        ArrayList<Node> visited = new ArrayList<>();
        int distance = -1;
        q.add(root);
        while(q.size()>0)
        {
            int size = q.size();
            for(int i=0;i<size;i++)
            {
                Node t = q.poll();
                if(t.left!=null)
                {
                    q.add(t.left);
                    hash.put(t.left, t);
                }
                if(t.right!=null)
                {
                    q.add(t.right);
                    hash.put(t.right, t);
                }
            }
        }
        q.clear();
        q.add(targ);
        while(q.size()>0)
        {
            distance++;
            int size = q.size();
            for(int i=0;i<size;i++)
            {
                Node t = q.poll();
                if(t.left!=null && !visited.contains(t.left))
                {
                    q.add(t.left);
                    visited.add(t.left);
                }
                if(t.right!=null && !visited.contains(t.right))
                {
                    q.add(t.right);
                    visited.add(t.right);
                }
                if(hash.containsKey(t) && !visited.contains(hash.get(t)))
                {
                    q.add(hash.get(t));
                    visited.add(hash.get(t));
                }
            }
        }
        return(distance);
    }
    static Node find_target(Node root, int target)
    {
        if(root == null)
            return null;
        if(root.data == target)
            return root;
        Node l = find_target(root.left, target);
        Node r = find_target(root.right, target);
        if(l!=null)
            return l;
        if(r!=null)
            return r;
        return null;
    }
}