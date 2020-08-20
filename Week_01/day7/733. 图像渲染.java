class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        int xLen = image.length;
        int yLen = image[0].length;

        boolean[][] visited = new boolean[xLen][yLen];
        int[] dx = new int[]{0,0,-1,1};
        int[] dy = new int[]{1,-1,0,0};

        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{sr,sc});
        int color = image[sr][sc];
        while(!stack.isEmpty()) {
            int[] xy = stack.pop();
            int x = xy[0];
            int y = xy[1];
            image[x][y] = newColor;
            visited[x][y] = true;
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && nx < xLen && ny >= 0 && ny < yLen && !visited[nx][ny] && color == image[nx][ny]){
                    stack.push(new int[]{nx,ny});
                } 
            }
        }
        return image;
    }
}