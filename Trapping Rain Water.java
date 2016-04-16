public class Solution {
    /**
     * @param matrix a matrix of m x n elements
     * @return an integer list
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        // Write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (matrix.length == 0) {
            return res;
        }
        int curRow = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int full = m * n;
        while (curRow <= m / 2) {
            for (int i = curRow; i < n - curRow; i++) {
                res.add(matrix[curRow][i]);
                if (res.size() == full) {
                    return res;
                }
            }
            for (int j = curRow + 1; j < m - curRow; j++) {
                res.add(matrix[j][n - curRow - 1]);
                if (res.size() == full) {
                    return res;
                }
            }
            for (int k = n - curRow - 2; k >= curRow; k--) {
                res.add(matrix[m - curRow - 1][k]);
                if (res.size() == full) {
                    return res;
                }
            }
            for (int l = m - curRow - 2; l > curRow; l--) {
                res.add(matrix[l][curRow]);
                if (res.size() == full) {
                    return res;
                }
            }
            curRow++;
        }
        return res;
    }
}