class Solution {
    /**
      * @param board: the board
        @return: wether the Sudoku is valid
      */
    public boolean isValidSudoku(char[][] board) {
        int row = board.length;
        int col = board.length;
        if (row != 9 || col != 9) {
            return false;
        }
        if (!checkRow(board) || !checkCol(board) || !checkNineBox(board)) {
            return false;
        }
        return true;
    }
    
    public boolean checkRow(char[][] board) {
        for (int i = 0; i < 9; i++) {
            boolean[] isOccu = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int position = board[i][j] - '0' - 1;
                    if (isOccu[position]) {
                        return false;
                    }
                    isOccu[position] = true;
                }
            }
        }
        return true;
    }
    
    public boolean checkCol(char[][] board) {
        for (int i = 0; i < 9; i++) {
            boolean[] isOccu = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.') {
                    int position = board[j][i] - '0' - 1;
                    if (isOccu[position]) {
                        return false;
                    }
                    isOccu[position] = true;
                }
            }
        }
        return true;
    }
    
    public boolean checkNineBox(char[][] board) {
        for (int i = 0; i < 9; i = i + 3) {
            for (int j = 0; j < 9; j = j + 3) {
                if (!checkBox(board, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean checkBox(char[][] board, int row, int col) {
        boolean[] isOccu = new boolean[9];
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                if (board[i][j] != '.') {
                    int position = board[i][j] - '0' - 1;
                    if (isOccu[position]) {
                        return false;
                    }
                    isOccu[position] = true;
                }
            }
        }
        return true;
    }
};
