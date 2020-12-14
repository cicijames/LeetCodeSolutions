//RunTime 1ms, Memory 41.8MB.

class Solution {
    public int numIslands(char[][] grid) {
        
        if(grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int cols = grid[0].length;
        int numIslands = 0;
        
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == '1') {
                    grid = discoverIsland(grid, i, j);
                    numIslands++;
                }
            }
        }
        return numIslands;
    }
    
    public static char[][] discoverIsland(char[][] grid, int row, int col) {
        grid[row][col] = 0;
        
        if(row < grid.length - 1 && grid[row + 1][col] == '1') {
            grid = discoverIsland(grid, row + 1, col);
        }
        if(col < grid[0].length - 1 && grid[row][col + 1] == '1') {
            grid = discoverIsland(grid, row, col + 1);
        }
        if(row > 0 && grid[row - 1][col] == '1') {
            grid = discoverIsland(grid, row - 1, col);
        }
        if(col > 0 && grid[row][col - 1] == '1') {
            grid = discoverIsland(grid, row, col - 1);
        }        
        return grid;
    }
}