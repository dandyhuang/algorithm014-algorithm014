class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        int k = 0;
        int preNum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (preNum != nums[i]) {
                preNum = nums[i];
                nums[++k] = preNum;
            }
        }
        return k + 1;
    }
}