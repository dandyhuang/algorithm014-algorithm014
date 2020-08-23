class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        
        if(k == 0) {
            return new int[0];
        }
        
        Queue<Integer> q = new PriorityQueue<>((a, b) -> b - a);

        for (int num : arr) {
            if (q.size() < k) {
                q.offer(num);
            } else if (num < q.peek()) {
                q.poll();
                q.offer(num);
            }
        }
        int[] res = new int[k];
        int idx = 0;
        for (int val : q) {
            res[idx++] = val;
        }
        return res;
    }
}