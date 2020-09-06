class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int len = rooms.size();
        boolean[] visited = new boolean[len];
        Stack<Integer> stack = new Stack<>();
        List<Integer> roomList = rooms.get(0);
        stack.add(0);
        visited[0] = true;
        while (!stack.isEmpty()) {
            int room = stack.pop();
            List<Integer> list = rooms.get(room);
            for (int r : list) {
                if (!visited[r]) {
                    stack.add(r);
                    visited[r] = true;
                }
            }
        }
        for (boolean b : visited) {
            if (!b) {
                return false;
            }
        }
        return true;
    }
}