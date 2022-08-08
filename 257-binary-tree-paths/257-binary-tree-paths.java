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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> str = new ArrayList<>();
        if(root != null)
            root_leaf(root ,"", str);
        return str;
    }
    public void root_leaf(TreeNode root, String path, List<String> str)
    {
        if( root.left == null && root.right == null)
            str.add(path + root.val);
        if(root.left != null)
            root_leaf(root.left, path + root.val + "->", str);
        if(root.right != null)
            root_leaf(root.right, path + root.val + "->", str);
    }
}