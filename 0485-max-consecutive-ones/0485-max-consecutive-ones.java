class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            int cnt = 0;
            if (nums[i] == 1) {
                while(i < nums.length && nums[i] == 1) {
                    cnt++;
                    i++;
                }
            }

            if (cnt > max) {
                max = cnt;
            }
        }

        return max;
    }
}