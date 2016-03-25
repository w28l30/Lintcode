public class Solution {
    /**
     * @param matrix: a matrix of 0 and 1
     * @return: an integer
     */
    public int maxSquare(int[][] matrix) {
        // write your code here
        int length = matrix.length;
        int depth = matrix[0].length;
        int maxArea = 0;
        int area;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < depth; j++) {
                if (matrix[i][j] == 1) {
                    area = getArea(matrix, length, depth, i, j);
                    if (area > maxArea) {
                        maxArea = area;
                    }
                }
            }
        }
        return maxArea;
    }

    public int getArea(int[][] matrix, int length, int depth, int x, int y) {
        int count = 1;
        while ((x + count) < length && (y + count) < depth) {
            for (int i = x; i <= x + count; i++) {
                if (matrix[i][y + count] == 0) {
                    return count * count;
                }
            }
            for (int j = y; j < y + count; j++) {
                if (matrix[x + count][j] == 0) {
                    return count * count;
                }
            }
            count++;
        }
        return count * count;
    }
    
}
