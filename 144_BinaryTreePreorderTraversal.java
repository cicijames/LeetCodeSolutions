//Runtime 0ms, Memory 37.3 MB

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
        List<Integer> order = new ArrayList<Integer>();
        if(root == null) {
            return order;
        }
        preorderTraversalHelper(root, order);
        return order;
    }
    
    public static void preorderTraversalHelper(TreeNode parent, List<Integer> order) {
        order.add(parent.val);
        if(parent.left != null) {
            preorderTraversalHelper(parent.left, order);
        }
        if(parent.right != null) {
            preorderTraversalHelper(parent.right, order);
        }
    }
}