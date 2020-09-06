class Solution {
    int minMutationCount = Integer.MAX_VALUE;

    public int minMutation(String start, String end, String[] bank) {
        dfsMutation(start, end, bank, new HashSet<>(), 0);
        return minMutationCount == Integer.MAX_VALUE ? -1 : minMutationCount;
    }

    private void dfsMutation(String start, String end, String[] bank, HashSet<Object> set, int count) {
        if (start.equals(end)) {
            minMutationCount = Math.min(count, minMutationCount);
            return;
        }

        for (String b : bank) {
            if(set.contains(b)) {
                continue;
            }
            int diff = 0;
            for (int i = 0; i < b.length(); i++) {
                if (start.charAt(i) != b.charAt(i)) {
                    if (++diff > 1) {
                        break;
                    }
                }
            }
            if(diff == 1) {
                set.add(b);
                dfsMutation(b,end,bank,set,count + 1);
                set.remove(b);
            }
        }
    }
}