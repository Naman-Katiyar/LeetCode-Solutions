class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int ans = Integer.MAX_VALUE;
        int max = nums[0];

        for (int i = 0; i < nums.length; i++) {
            //Updating max value
            if (nums[i] > max) {
                max = nums[i];
            }

            //Finding min value
            int min = Integer.MAX_VALUE;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] < min) {
                    min = nums[j];
                }
            }

            int instabilityScore = max - min;

            //Updating ans
            if (instabilityScore <= k) {
                return i;
            }
        }
        return -1;
    }
}