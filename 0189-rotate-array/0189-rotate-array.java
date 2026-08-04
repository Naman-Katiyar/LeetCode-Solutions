class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        int[] ans = new int[n];

        int idx = 0;

        //Storing last elements
        for (int i = n - k; i < n; i++) {
            ans[idx] = nums[i];
            idx++;
        }

        //Storing starting elements
        for (int i = 0; i < n - k; i++) {
            ans[idx] = nums[i];
            idx++;
        }

        //Copying element in original array
        for (int i = 0; i < n; i++) {
            nums[i] = ans[i];
        }

    }
}