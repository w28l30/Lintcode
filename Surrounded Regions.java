public class Solution {
    /**
     * @param board a 2D board containing 'X' and 'O'
     * @return void
     */
    public void surroundedRegions(char[][] board) {
        // Write your code here
        if (board == null || board.length == 0) {
            return;
        }
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < col; i++) {
            traversal(board, 0, i);
            if (row > 1) {
                traversal(board, row - 1, i);
            }
        }
        for (int j = 1; j < row; j++) {
            traversal(board, j, 0);
            if (col > 1) {
                traversal(board, j, col - 1);
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == '1') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    public void traversal(char[][] board, int row, int col) {
        if (board[row][col] == 'O') {
            board[row][col] = '1';
            if (row + 1 < board.length)
            traversal(board, row + 1, col);
            if (row > 1)
            traversal(board, row - 1, col);
            if (col + 1 < board[0].length)
            traversal(board, row, col + 1);
            if (col > 1)
            traversal(board, row, col - 1);
        }
    }
}