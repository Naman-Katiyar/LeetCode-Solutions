class Solution {
    public int removeDuplicates(int[] nums) {
        int idx = 0;
        int k = 0;

        for (int i = 0; i < nums.length; ) {
            int unique = nums[i];
            nums[idx] = unique;
            idx++;
            k++;

            while (i < nums.length && unique == nums[i]) {
                i++;
            }
        }
        return k;
    }
}