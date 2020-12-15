//Runtime 3ms, Memory 41.8 MB

class TicTacToe {
    
    int[][] gameBoard;
    int size;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        gameBoard = new int[n][n];
        size = n;
    }
    
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        gameBoard[row][col] = player;


        if(gameBoard[0][col] == player && gameBoard[size - 1][col] == player) {
            if(countInDirection(player, 0, col, 0, 1) == size) {
                return player;
            }
        }
        if(gameBoard[row][0] == player && gameBoard[row][size - 1] == player) {
            if(countInDirection(player, row, 0, 1, 0) == size) {
                return player;
            }
        }
        if(row + col == size - 1 && gameBoard[0][size - 1] == player && gameBoard[size - 1][0] == player) {
            if(countInDirection(player, 0, size - 1, -1, 1) == size) {
                return player;
            }
        }
        if(row == col && gameBoard[0][0] == player && gameBoard[size - 1][size - 1] == player) {
            if(countInDirection(player, 0, 0, 1, 1) == size) {
                return player;
            }
        }       
        return 0;
    }
    
    public int countInDirection(int player, int row, int col, int x, int y) {
        //x = 1, y = 0 is checking the horizontal.
        //x = 1, y = 1 is checking left corner diagonal.
        //x = 1, y = -1 is checking the right corner diagonal.
        if(gameBoard[row][col] != player) {
            return 0;
        }
        int touches = 1;
        if(row + y < size && col + x < size && row + y >= 0 && col + x >= 0) {
            touches += countInDirection(player, row + y, col + x, x, y);
        }
        return touches;
    }
    
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */