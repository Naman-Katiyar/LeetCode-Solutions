class Solution {
    public int countRatioSubarrays(int[] nums, int a, int b) {

        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            int evenCnt = 0;
            int oddCnt = 0;

            for (int j = i; j < nums.length; j++) {
                    if (nums[j] % 2 == 0) {
                        evenCnt++;
                    } else {
                        oddCnt++;
                    }

                if (oddCnt > 0 && (evenCnt * b) <= (oddCnt * a)) {
                    ans++;
                }
            }
        }
        return ans;
    }
}