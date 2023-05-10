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
        HashMap<Node, Node> parent = new HashMap<>();
        find_parent(root, parent);
        Node target_get = find_target(root, target);
        return(find_distant_node(target_get, parent, 0));
    }
    public static Node find_target(Node root, int val)
    {
        if(root == null)
            return root;
        if(root.data == val)
            return root;
        Node l = find_target(root.left, val);
        Node r = find_target(root.right, val);
        if(l == null)
            return r;
        if(r == null)
            return l;
        return l;
    }
    public static int find_distant_node(Node root, HashMap<Node, Node> parent, int k)
    {
        if(root == null)
            return 0;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        List<Integer> visited = new ArrayList<>();
        while (q.size() > 0)
        {
            k++;
            int size = q.size();
            for(int i=0;i<size;i++)
            {
                Node t = q.poll();
                visited.add(t.data);
                if(t.left != null && !visited.contains(t.left.data))
                    q.add(t.left);
                if(t.right != null && !visited.contains(t.right.data))
                    q.add(t.right);
                if(parent.containsKey(t) && !visited.contains(parent.get(t).data))
                    q.add(parent.get(t));
            }
        }
        return k-1;
    }
    public static void find_parent(Node root, HashMap<Node, Node> parent)
    {
        if(root == null)
            return;
        if(root.left != null)
        {
            parent.put(root.left, root);
            find_parent(root.left, parent);
        }
        if(root.right != null)
        {
            parent.put(root.right, root);
            find_parent(root.right, parent);
        }
    }
}