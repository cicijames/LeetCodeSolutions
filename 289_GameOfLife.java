//Runtime 1ms,  Memory 37.3 MB

class Solution {
    public void gameOfLife(int[][] board) {
        if(board.length == 0 || board[0].length == 0) {
            return;
        }
        Set<Integer> changed = new HashSet<Integer>();
        int[][] toCheck = new int[][] {{-1, -1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        int cols = board[0].length;
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < cols; j++) {
                boolean isLive = board[i][j] == 1 ? true : false;
                int count = 0;
                for(int[] cell : toCheck) {
                    count += getCell(board, i + cell[0], j + cell[1], changed);
                    if(isLive && count > 3) {
                        break;
                    }
                }
                if((isLive && (count < 2 || count > 3)) || (!isLive && count == 3)) {
                    changed.add(i * cols + j);
                    board[i][j] = board[i][j] == 1 ? 0 : 1;
                }
            }
        }       
    }
   
    public static int getCell(int[][] board, int row, int col, Set<Integer> changed) {
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return 0;
        }
        if(changed.contains(row * board[0].length + col)) {
            return board[row][col] == 1 ? 0 : 1;
        }
        return board[row][col];
    }
}