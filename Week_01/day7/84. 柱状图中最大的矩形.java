class Solution {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int[] left = new int[len];
        int[] right = new int[len];
        Arrays.fill(right, len);
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                right[stack.pop()] = i;
            }

            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        int max_area = 0;
        for (int i = 0; i < len; i++) {
            max_area = Math.max(max_area, heights[i] * (right[i] - left[i] - 1));
        }
        return max_area;
    }
}
