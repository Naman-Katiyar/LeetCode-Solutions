class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int ans = Integer.MAX_VALUE;
        int max = nums[0];

        //Storing min values in HashMap
        HashMap <Integer, Integer> map = new HashMap <> ();
        int min = nums[nums.length - 1];
        for (int i = nums.length-1; i >= 0; i--) {
            //Updating min
            if (nums[i] < min) {
                min = nums[i];
            }

            map.put(i, min);
        }

        for (int i = 0; i < nums.length; i++) {
            //Updating max value
            if (nums[i] > max) {
                max = nums[i];
            }

            //Fetching min from HashMap
            int minn = map.get(i);

            int instabilityScore = max - minn;

            //Updating ans
            if (instabilityScore <= k) {
                return i;
            }
        }
        return -1;
    }
}