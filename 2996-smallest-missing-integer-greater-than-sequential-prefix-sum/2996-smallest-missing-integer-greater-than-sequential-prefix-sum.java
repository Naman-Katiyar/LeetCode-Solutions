class Solution {
    private boolean contains(int[] nums, int sum) {
        for (int k: nums) {
            if (k == sum) {
                return true;
            }
        }
        return false;
    }
    
    public int missingInteger(int[] nums) {
        int sum = nums[0];

        int i = 1;
        while (i < nums.length && nums[i] == nums[i - 1] + 1) {
            sum += nums[i];
            i++;
        }

        while (contains(nums, sum)) {
            sum++;
        }

        return sum;
    }
}