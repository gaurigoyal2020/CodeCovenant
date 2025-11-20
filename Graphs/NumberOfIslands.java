// <========= DFS =========> //

class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        int count = 0;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j){
        if(i < 0 || i>= grid.length ||
           j < 0 || j>= grid[0].length ||
           grid[i][j] == '0') {
            return;
           }

        grid[i][j] = '0'; //Essentially mark the node as visited by making it it water
        //(based on our condition above, we'll not perform dfs on it since it's !'1')

        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
    }
}

// <========= BFS =========> //

class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        for(int i =0; i < rows; i++){
            for( int j=0; j<cols; j++){
                if(grid[i][j] == '1'){
                    bfs(grid, i, j, rows, cols);
                    count++;
                }
            }
        }
        return count;
    }

    private void bfs(char[][] grid, int i, int j, int rows, int cols) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {i, j});
        grid[i][j] = '0';
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0, -1}};

        while(!q.isEmpty()) {
            int point[] = q.poll();
            int row = point[0];
            int col = point[1];

            for(int dir[] : directions) {
                int newr = row + dir[0];
                int newc = col + dir[1];
                if(newr >= 0 && newr < rows && newc >= 0 && newc < cols && grid[newr][newc] == '1'){
                    q.add(new int[] {newr, newc});
                    grid[newr][newc] = '0';
                }
            }
        }
    }
}
