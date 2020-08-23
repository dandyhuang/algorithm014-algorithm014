class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numMap = new HashMap<>();
        int[] res = new int[k];
        for (int num : nums) {
            numMap.put(num, numMap.getOrDefault(num, 0) + 1);
        }
        Queue<int[]> queue = new PriorityQueue<int[]>((a, b) ->
                b[0] - a[0]
        );
        for (Map.Entry<Integer, Integer> entry : numMap.entrySet()) {
            queue.add(new int[]{entry.getValue(), entry.getKey()});
        }
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll()[1];
        }
        return res;
    }
}