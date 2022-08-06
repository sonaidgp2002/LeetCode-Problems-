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
        // ArrayList<TreeNode> list1 = new ArrayList<>();
        // //ArrayList<Integer> list2 = new ArrayList<>();
        // inorder(root, list1);
        // // inorder(subRoot, list2);
        // // int counter = 0;
        // int index = list1.indexOf(subRoot);
        // return isSameTree(list1.get(index), subRoot);
        // Stack<TreeNode> stk = new Stack<>();
        // stk.push(root);
        // TreeNode temp1 = null;
        // while(stk.size() != 0)
        // {
        //     TreeNode temp = stk.pop();
        //      if(temp.right != null && temp.val == temp.right.val)
        //      {
        //         if(!stk.isEmpty())
        //         stk.pop();
        //         temp = temp.right;
        //      }
        //     if(temp.left != null && temp.val == temp.left.val)
        //      {
        //         if(!stk.isEmpty())
        //         stk.pop();
        //         temp = temp.left;
        //      }
        //     if(temp.right != null && temp.val != temp.right.val)
        //         stk.push(temp.right);
        //     if(temp.left != null && temp.val != temp.left.val)
        //         stk.push(temp.left);
        //     if(temp.val == subRoot.val)
        //     {
        //         temp1 = temp;
        //         break;
        //     }
        // }
        if(root == null && subRoot == null)
            return true;
        if(root == null||subRoot == null)
            return false;
        boolean ans = isSameTree(root,subRoot);
        boolean res1 = isSubtree(root.left,subRoot);
        boolean res2 = isSubtree(root.right,subRoot);
        return ans||res1||res2;
    }
    // public void inorder(TreeNode root, TreeNode subRoot)
    // {
    //     if( root == null)
    //         return;
    //     if(subRoot.val == root.val)
    //         list.add(root);
    //     inorder( root.left, subRoot );
    //     inorder( root.right, subRoot );
    // }
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