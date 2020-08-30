class Solution {
    public List<List<String>> solveNQueens(int n) {

        List<List<String>> resList = new ArrayList<>();
        List<Integer> pieList = new ArrayList<>();
        List<Integer> naList = new ArrayList<>();
        List<Integer> colList = new ArrayList<>();
        backTrackingQueens(n, pieList, naList, colList, new ArrayList<>(), resList);
        return resList;
    }

    private void backTrackingQueens(int n, List<Integer> pieList, List<Integer> naList, List<Integer> colList, List<Integer> list, List<List<String>> resList) {

        int row = list.size();
        if (row == n) {
            List<String> activeList = new ArrayList<>();
            for (int idx : list) {
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < idx; i++) {
                    sb.append(".");
                }
                sb.append("Q");
                for (int j = idx + 1; j < n; j++) {
                    sb.append(".");
                }
                activeList.add(sb.toString());
            }
            resList.add(activeList);
        }

        for (int i = 0; i < n; i++) {
            int nPieVal = row + i;
            int nNaVal = i - row;
            if (!colList.contains(i) && !pieList.contains(nPieVal) && !naList.contains(nNaVal)) {
                pieList.add(nPieVal);
                naList.add(nNaVal);
                list.add(i);
                colList.add(i);
                backTrackingQueens(n, pieList, naList, colList, list, resList);
                pieList.remove(pieList.size() - 1);
                naList.remove(naList.size() - 1);
                list.remove(list.size() - 1);
                colList.remove(colList.size() - 1);
            }
        }

    }
}