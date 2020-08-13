class Solution {
    public void solve(char[][] board) {
        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};

        int n = board.length;
        if (n == 0) {
            return;
        }
        int m = board[0].length;
        LinkedList<int[]> list = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            if (board[0][i] == 'O') {
                list.add(new int[]{0, i});
            }
            if (board[n - 1][i] == 'O') {
                list.add(new int[]{n - 1, i});
            }
        }
        for (int i = 1; i < n - 1; i++) {
            if (board[i][0] == 'O') {
                list.add(new int[]{i, 0});
            }
            if (board[i][m - 1] == 'O') {
                list.add(new int[]{i, m - 1});
            }
        }
        while (!list.isEmpty()) {
            int[] dxy = list.poll();
            int x = dxy[0];
            int y = dxy[1];
            board[x][y] = 'A';
            for (int i = 0; i < 4; i++) {
                int x1 = dx[i] + x;
                int y1 = dy[i] + y;
                if (x1 >= 0 && x1 < n && y1 >= 0 && y1 < m && board[x1][y1] == 'O') {
                    list.add(new int[]{x1, y1});
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
}