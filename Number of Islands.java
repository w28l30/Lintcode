public class Solution {
    /**
     * @param grid a boolean 2D matrix
     * @return an integer
     */
    public int numIslands(boolean[][] grid) {
        // Write your code here
        if (grid == null) {
            return 0;
        }
        int row = grid.length;
        if (row == 0) {
            return 0;
        }
        int col = grid[0].length;
        
        boolean[][] marked = new boolean[row][col];
        int count = 0;
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == true && marked[i][j] == false) {
                    marked[i][j] = true;
                    count++;
                    traversal(marked, grid, i, j, row, col);
                }
            }
        }
        
        return count;
    }
    
    public void traversal(boolean[][] marked, boolean[][] grid, int i, int j, int row, int col) {
        if (i > 0) {
            if (grid[i - 1][j] == true && marked[i - 1][j] == false) {
                marked[i - 1][j] = true;
                traversal(marked, grid, i - 1, j, row, col);
            }
        }
        if (i < row - 1) {
            if (grid[i + 1][j] == true && marked[i + 1][j] == false) {
                marked[i + 1][j] = true;
                traversal(marked, grid, i + 1, j, row, col);
            }
        }
        if (j > 0) {
            if (grid[i][j - 1] == true && marked[i][j - 1] == false) {
                marked[i][j - 1] = true;
                traversal(marked, grid, i, j - 1, row, col);
            }
        }
        if (j < col - 1) {
            if (grid[i][j + 1] == true && marked[i][j + 1] == false) {
                marked[i][j + 1] = true;
                traversal(marked, grid, i, j + 1, row, col);
            }
        }
    }
}
