class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        int len1 = nums1.length;
        int len2 = nums2.length;

        for (int i = 0; i < len1; i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        }
        int[] res = new int[len1];
        int idx = 0;
        for (int i = 0; i < len2; i++) {
            if (map.containsKey(nums2[i])) {
                res[idx++] = nums2[i];
                if (map.get(nums2[i]) > 1) {
                    map.put(nums2[i], map.get(nums2[i]) - 1);
                } else {
                    map.remove(nums2[i]);
                }
            }
        }
        return Arrays.copyOfRange(res, 0, idx);
    }
}