class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = len - 1; i >= 0; i--) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            }
        }
        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < len; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int target = 0 - nums[i] - nums[j];
                int k = map.getOrDefault(target, 0);
                if (k > j) {
                    List<Integer> l = new ArrayList<>();
                    l.add(nums[i]);
                    l.add(nums[j]);
                    l.add(nums[k]);
                    resList.add(l);
                }
            }
        }
        return resList;
    }
}