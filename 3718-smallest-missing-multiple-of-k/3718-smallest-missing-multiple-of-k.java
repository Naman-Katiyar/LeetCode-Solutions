class Solution {
    public int missingMultiple(int[] nums, int k) {
        Arrays.sort(nums);
        int largest = nums[nums.length - 1];

        HashSet <Integer> set = new HashSet <> ();
        for (int el: nums) {
            if (el % k == 0) {
                set.add(el);
            }
        }

        if (k > largest) {
            return k;
        }

        int multiple = k;
        while (k <= largest) {
            if(!set.contains(multiple)) {
                return multiple;
            }
            multiple += k;
        }
        return -1;
    }
}