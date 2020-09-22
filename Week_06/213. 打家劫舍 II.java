class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        return Math.max(rob2(nums, 0, nums.length - 1), rob2(nums, 1, nums.length));
    }
    public int rob2(int[] nums, int start, int end) {
        int first = 0;
        int second = 0;
        for(int i = start; i < end; i++) {
            int temp = second;
            second = Math.max(second, nums[i] + first);
            first = temp;
        }
        return second;
    }
}