//RunTime 1 ms, Memory 47.8 MB.

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int totalProduct = 1;
        boolean hadZero = false;
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
               totalProduct *= nums[i]; 
            }
            else if(hadZero) {
                Arrays.fill(nums, 0);
                return nums;
            }
            else {
                hadZero = true;
            }
        }
        
        for(int j = 0; j < nums.length; j++) {
            if(nums[j] == 0) {
                nums[j] = totalProduct;
            }
            else if(hadZero) {
                nums[j] = 0;
            }
            else {
                nums[j] = totalProduct / nums[j];
            }
        }
        return nums;
    }
}