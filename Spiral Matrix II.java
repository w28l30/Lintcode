public class Solution {
    /**
     * @param n an integer
     * @return a square matrix
     */
    public int[][] generateMatrix(int n) {
        // Write your code here
        int[][] matrix = new int[n][n];
        if (n <= 0) {
            return matrix;
        }
        int N = n;
        int curNum = 1;
        int pos = 0;
        while (pos <= N / 2) {
            for (int i = pos; i < n - pos; i++) {
                matrix[pos][i] = curNum++;
            }
            for (int j = pos + 1; j < n - pos; j++) {
                matrix[j][n - pos - 1] = curNum++;
            }
            for (int k = n - pos - 2; k >= pos; k--) {
                matrix[n - pos - 1][k] = curNum++;
            }
            for (int l = n - pos - 2; l > pos; l--) {
                matrix[l][pos] = curNum++;
            }
            pos++;
        }
        return matrix;
    }
}