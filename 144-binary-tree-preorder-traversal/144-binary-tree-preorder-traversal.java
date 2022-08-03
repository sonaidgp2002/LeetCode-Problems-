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
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stk = new Stack<>();
        List<Integer> list = new ArrayList<>();
        if(root == null)
            return list;
        stk.push(root);
        while(stk.size() != 0)
        {
            TreeNode temp = stk.pop();
            list.add( temp.val );
            if(temp.right != null)
                stk.push(temp.right);
            if(temp.left != null)
                stk.push(temp.left);
            //list.add( stk.pop().val );
        }
        return list;
    }
}