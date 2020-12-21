//Runtime 0ms, Memory 47.2 MB

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
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) {
            return 0;
        }
        int sum = 0;
        if(root.val <= high && root.val >= low) {
            sum += root.val;
        }
        sum += root.val > high ? 0 : rangeSumBST(root.right, low, high);
        sum += root.val <= low ? 0 : rangeSumBST(root.left, low, high);

        return sum;
    }

}