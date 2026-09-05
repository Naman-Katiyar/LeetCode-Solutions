class Solution {
    public void sortColors(int[] nums) {
        //Dutch National Flag Algorithm
        int temp = 0;
        int mid = 0;
        int low = 0;
        int high = nums.length-1; //n-1

        while(mid <= high) {
            //Found 0
            if(nums[mid] == 0) {
                temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                mid++;
                low++;
            } else if(nums[mid] == 1) { //Found 1
                mid++;
            } else { //Found 2
                temp = nums[high];
                nums[high] = nums[mid];
                nums[mid] = temp;
                high--;
            }
        }
    }
}