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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null)
            return false;
        ArrayList<Integer> str = new ArrayList<>();
        root_leaf(root, 0, str);
        if(str.contains(targetSum))
            return true;
        return false;
    }
    public void root_leaf(TreeNode root, int sum, List<Integer> str)
    {
        if( root.left == null && root.right == null)
            str.add(sum + root.val);
        if(root.left != null)
            root_leaf(root.left, sum + root.val, str);
        if(root.right != null)
            root_leaf(root.right, sum + root.val, str);
    }
}