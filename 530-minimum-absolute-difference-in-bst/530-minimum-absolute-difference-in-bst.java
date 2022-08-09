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
    public int getMinimumDifference(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();
        preorder(root, arr);
        Collections.sort(arr);
        System.out.println(arr);
        int diff = Integer.MAX_VALUE;
        for(int i=0;i<arr.size()-1; i++)
        {
            if((arr.get(i+1) - arr.get(i)) < diff)
                diff = arr.get(i+1) - arr.get(i);
        }
        return diff;
    }
    public void preorder(TreeNode root, ArrayList<Integer> arr)
    {
        if(root == null)
            return;
        arr.add(root.val);
        preorder(root.left, arr);
        preorder(root.right, arr);
    }
}