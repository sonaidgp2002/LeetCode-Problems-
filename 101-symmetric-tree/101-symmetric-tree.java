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
    public boolean isSymmetric(TreeNode root) {
        root.right = invertTree(root.right);
        return isSameTree(root.left, root.right);
    }
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if( p ==null && q ==  null)
            return true;
        if( p != null && q != null)
        {
             if(p.val != q.val)
                 return false;
        }
        if(( p == null && q != null) || ( p != null && q == null))
            return false;
        boolean t = isSameTree(p.left, q.left);
        boolean t1 = isSameTree(p.right, q.right);
        return (t & t1);
    }
}