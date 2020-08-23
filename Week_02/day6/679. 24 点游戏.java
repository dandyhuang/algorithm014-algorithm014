class Solution {
    final int TARGET = 24;
    final double EPSILON = 1e-6;
    final int ADD = 0, MULTIPLY = 1, SUBTRACT = 2, DIVIDE = 3;

    public boolean judgePoint24(int[] nums) {

        List<Double> numList = new ArrayList<>();
        for (int num : nums) {
            numList.add((double) num);
        }
        return solve24(numList);
    }

    private boolean solve24(List<Double> numsList) {

        if (numsList.size() == 1) {
            return Math.abs(numsList.get(0) - TARGET) < EPSILON;
        }
        int size = numsList.size();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                List<Double> resList2 = new ArrayList<>();
                if (i != j) {
                    for (int k = 0; k < size; k++) {
                        if (k != i && k != j) {
                            resList2.add(numsList.get(k));
                        }
                    }
                    for (int k = 0; k < 4; k++) {
                        if (k < 2 && i > j) {
                            continue;
                        }
                        switch (k) {
                            case ADD:
                                resList2.add(numsList.get(i) + numsList.get(j));
                                break;
                            case MULTIPLY:
                                resList2.add(numsList.get(i) * numsList.get(j));
                                break;
                            case SUBTRACT:
                                resList2.add(numsList.get(i) - numsList.get(j));
                                break;
                            case DIVIDE:
                                if (Math.abs(numsList.get(j)) > EPSILON) {
                                    resList2.add(numsList.get(i) / numsList.get(j));
                                } else {
                                    continue;
                                }
                                break;
                        }
                        if (solve24(resList2)) {
                            return true;
                        }
                        resList2.remove(resList2.size() - 1);
                    }
                }
            }
        }
        return false;
    }
}