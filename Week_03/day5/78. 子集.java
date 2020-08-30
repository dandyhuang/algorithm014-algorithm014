class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        backtrack(0, nums, resList, new ArrayList<>());
        return resList;
    }

    private void backtrack(int start, int[] nums, List<List<Integer>> resList, List<Integer> list) {
        resList.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            backtrack(i + 1, nums, resList, list);
            list.remove((Object) nums[i]);
        }
    }
}