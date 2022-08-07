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
    // ArrayList<TreeNode> list = new ArrayList<>();
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null)
            return true;
        if(root == null||subRoot == null)
            return false;
        boolean ans = isSameTree(root,subRoot);
        boolean res1 = isSubtree(root.left,subRoot);
        boolean res2 = isSubtree(root.right,subRoot);
        return ans||res1||res2;
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