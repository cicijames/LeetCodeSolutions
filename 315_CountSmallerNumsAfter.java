//Runtime 5ms, Memory 41.2 MB

class TreeNode {
    TreeNode right;
    TreeNode left;
    int value;
    int leftChildren;
    
    public TreeNode(int value) {
        this.value = value;
        leftChildren = 0;
    } 

    public int insert(TreeNode node, int countSmaller) {
        if(node.value >= value) {
            countSmaller += node.value > value ? 1 + leftChildren : leftChildren; 
            if(right == null) {
                right = node;
                return countSmaller;
            }
            return right.insert(node, countSmaller);
        }
        leftChildren++;
        if(left == null) {
            left = node;
            return countSmaller;
        }
        return left.insert(node, countSmaller);
    }
}

class Solution {
    public List<Integer> countSmaller(int[] nums) {
        if(nums.length == 0) {
            return new ArrayList<Integer>();
        }
        if(nums.length == 1) {
            return new ArrayList<Integer>(List.of(0));
        }
        
        List<Integer> smallerList = new LinkedList<Integer>();
        smallerList.add(0);
        int length = nums.length;
        TreeNode root = new TreeNode(nums[length - 1]);
        for(int i = length - 2; i >= 0; i--) {
            TreeNode node = new TreeNode(nums[i]);
            smallerList.add(0, root.insert(node, 0));
        }
        
        return smallerList;
    }
}