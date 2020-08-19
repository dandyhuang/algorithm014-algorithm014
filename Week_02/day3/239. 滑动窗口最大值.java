class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[]{};
        }
        Deque<Integer> q = new LinkedList<>();
        int len = nums.length;
        int[] res = new int[len - k + 1];
        for (int i = 0; i < k - 1; i++) {
            while (!q.isEmpty() && q.getLast() < nums[i]) {
                q.removeLast();
            }
            q.addLast(nums[i]);
        }
        for (int i = k - 1; i < len; i++) {
            if (i >= k && q.getFirst() == nums[i - k]) {
                q.removeFirst();
            }
            while (!q.isEmpty() && q.getLast() < nums[i]) {
                q.removeLast();
            }
            q.addLast(nums[i]);
            res[i - k + 1] = q.getFirst();
        }
        return res;
    }
}