//Runtime 1ms, Memory 39.3 MB

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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        
        List<List<Integer>> paths = new ArrayList<List<Integer>>();
        if(root == null) {
            return paths;    
        }
        if(root.val == sum && root.left == null && root.right == null) {
            paths.add(new ArrayList<Integer>(List.of(sum)));
            return paths;
        }
        
        Deque<Integer> currentStack = new ArrayDeque<Integer>();
        pathSumHelper(root, sum, paths, currentStack);
        
        return paths;
    }
    
    public static void pathSumHelper(TreeNode node, int sumRemaining, List<List<Integer>> paths, Deque<Integer> currentStack) {        
        sumRemaining -= node.val;
        currentStack.addLast(node.val);
        
        if(sumRemaining == 0 && node.right == null && node.left == null) {
            Object[] array = currentStack.toArray();
            paths.add(new ArrayList<Integer>(currentStack));
            currentStack.removeLast();
            return;
        }
        
        if(node.left != null) {
            pathSumHelper(node.left, sumRemaining, paths, currentStack);
        }
        if(node.right != null) {
            pathSumHelper(node.right, sumRemaining, paths, currentStack);
        }           
        currentStack.removeLast();
    }
}