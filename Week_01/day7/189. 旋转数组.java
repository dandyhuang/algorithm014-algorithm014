class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        int count = 0;
        k = k % len;
        for (int start = 0; count < len; start++) {
            int current = start;
            int preNum = nums[start];

            do {
                current = (current + k) % len;
                int temp = nums[current];
                nums[current] = preNum;
                preNum = temp;
                count++;
            } while (current != start);

        }
    }
}