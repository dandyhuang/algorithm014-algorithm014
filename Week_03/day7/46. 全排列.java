class Solution {
    List<List<Integer>> resList = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<Integer> outlist = new ArrayList<>();
        Arrays.stream(nums).forEach(a -> outlist.add(a));

        traversalPermute(outlist, nums, 0);

        return resList;
    }

    private void traversalPermute(List<Integer> outList, int[] nums, int first) {

        if (first == nums.length) {
            resList.add(new ArrayList<>(outList));
            return;
        }
        for (int i = first; i < nums.length; i++) {
            Collections.swap(outList, first, i);
            traversalPermute(outList, nums, first + 1);
            Collections.swap(outList, first, i);
        }
    }
}