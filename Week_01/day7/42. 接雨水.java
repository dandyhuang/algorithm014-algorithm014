class Solution {
    public int trap(int[] height) {
        int len = height.length;
        int[] left = new int[len];
        int[] right = new int[len];

        int leftMax = 0;
        for (int i = 1; i < len; i++) {
            leftMax = Math.max(leftMax, height[i - 1]);
            left[i] = leftMax;
        }
        int rightMax = 0;
        for (int i = len - 2; i >= 0; i--) {
            rightMax = Math.max(height[i + 1], rightMax);
            right[i] = rightMax;
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            int val = Math.min(left[i], right[i]) - height[i];
            res = res + (val > 0 ? val : 0);
        }
        return res;
    }
}