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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();
        if(root == null)
            return list;
        TreeNode temp = root;
        stk.push( root );
        while( !stk.isEmpty() )
        {
            temp = stk.pop();
            list.add(0, temp.val);
            if( temp.left != null )
                stk.add(temp.left);
            if( temp.right != null )
                stk.add(temp.right);
        }
        return list;
    }
}