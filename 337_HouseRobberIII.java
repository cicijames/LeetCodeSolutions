//Runtime 0 ms, Memory 38.6 MB

//[4,1,null,2,null,3]
//[3,2,3,null,3,null,1]

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
    public int rob(TreeNode root) {  
        if(root == null) {
            return 0;
        }
        if(root.right == null && root.left == null) {
            return root.val;
        }
        
        int[] ret = robHelper(root);      
        return Math.max(ret[1], ret[0]); 
    }
    
    //int[maxWithLastValue, maxWithoutLastValue]
    public static int[] robHelper(TreeNode node) {   
        if(node.right == null && node.left == null) {
            return new int[] {node.val, 0};
        }
        
        int[] child; 
        if(node.right != null) {
            child = robHelper(node.right);
            if(node.left != null) {
                int[] left = robHelper(node.left);
                int usingChildren = left[0] + child[0];
                usingChildren = Math.max(usingChildren, left[0] + child[1]);
                usingChildren = Math.max(usingChildren, child[0] + left[1]);
                child[0] = usingChildren;  
                child[1] += left[1];
            }
        }
        else {
            child = robHelper(node.left);
        }      
        return new int[] {node.val + child[1], Math.max(child[0], child[1])};
    }   
}