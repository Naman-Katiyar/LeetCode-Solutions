class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> list = new ArrayList <> ();

        Arrays.sort(nums);

        int smallest = nums[0];
        int largest = nums[nums.length - 1];

        int idx = 0;
        for (int i = smallest; i <= largest; i++) {
            if (nums[idx] == i) {
                idx++;
            } else {
                list.add(i);
            }
        }

        return list;
    }
}