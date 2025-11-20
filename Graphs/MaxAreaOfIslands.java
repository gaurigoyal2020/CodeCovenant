class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0)
            return 0;
        int currAr=0, maxAr = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    currAr = dfs(grid, i, j);
                    maxAr = Math.max(maxAr, currAr);
                }
            }
        }
        return maxAr;
    }
    private int dfs(int[][] grid, int i, int j) {
        if(i<0 || i>=grid.length || j<0 || j>= grid[0].length || grid[i][j] == 0)
            return 0;
        grid[i][j] = 0;

        int currAr = 1;

        currAr += dfs(grid, i+1, j);
        currAr += dfs(grid, i-1, j);
        currAr += dfs(grid, i, j+1);
        currAr += dfs(grid, i, j-1);

        return currAr;
    }
}
