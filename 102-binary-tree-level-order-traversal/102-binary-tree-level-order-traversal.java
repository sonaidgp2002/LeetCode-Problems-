/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
	  if(root == null)
	  return list;
	  Queue<TreeNode> q = new LinkedList<>();
	  q.add( root );
	  while(q.size() != 0)
	  {
	      int length = q.size();
	      List<Integer> arr = new ArrayList<>();
	      for(int i = 0; i < length; i++)
	      {
	          if(q.peek().left != null) q.add(q.peek().left);
	          if(q.peek().right != null) q.add(q.peek().right);
	          arr.add( q.poll().val );
	      }
	      list.add( arr );
	  }
	  return list;
    }
}