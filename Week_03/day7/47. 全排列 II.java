class Solution {
    List<List<Integer>> resList = new LinkedList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        boolean[] visited = new boolean[len];
        traversalPermute(new LinkedList<>(), nums, visited);

        return resList;
    }

    private void traversalPermute(LinkedList<Integer> list, int[] nums, boolean[] visited) {

        if (list.size() == nums.length) {
            resList.add(new LinkedList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i-1] == nums[i] && !visited[i-1]) {
                //去除重复排列
                continue;
            }
            if (!visited[i]) {
                visited[i] = true;
                list.add(nums[i]);
                traversalPermute(list, nums, visited);
                list.removeLast();
                visited[i] = false;
            }
        }
    }

}