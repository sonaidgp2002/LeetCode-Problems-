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
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        int lh = length(root.left);
        int rh = length(root.right);
        if(( lh + rh) > max)
            max = lh + rh;
        return max;
        //return (lh + rh);
    }
    public int length(TreeNode root)
    {
        if(root == null)
            return 0;
        int lh = length(root.left);
        int rh = length(root.right);
        if(( lh + rh) > max)
            max = lh + rh;
        return 1 + Math.max(lh, rh);
    }
}