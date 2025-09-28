class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++) {
                if(board[i][j] == '.')
                    continue;
                if(!validRow(board, i, j, board[i][j]) ||
                    !validColumn(board, i, j, board[i][j]) ||
                    !validGrid(board, i, j, board[i][j]))
                    return false;
            }
        }
        return true;
    }

    private boolean validRow(char[][] board, int row, int col, char digit) {
        for(int k=0; k<9; k++){
            if(k!=row && board[k][col] == digit)
                return false;
        }
        return true;
    }

    private boolean validColumn(char[][] board, int row, int col, char digit) {
        for(int k=0; k<9; k++){
            if(k!=col && board[row][k] == digit)
                return false;
        }
        return true;
    }

    private boolean validGrid(char[][] board, int row, int col, char digit) {
        int startRow = row - row%3;
        int startCol = col - col%3;
        for(int k=startRow; k<startRow+3; k++) {
            for(int l=startCol; l<startCol+3; l++){
                if(k!=row && l!=col && board[k][l] == digit)
                    return false;
            }
        }
        return true;
    }
}
