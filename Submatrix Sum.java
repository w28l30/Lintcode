public class Solution {
    /**
     * @param matrix an integer matrix
     * @return the coordinate of the left-up and right-down number
     */
    public int[][] submatrixSum(int[][] matrix) {
        // Write your code here
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int[][] res = new int[2][2];
         
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    dp[i][j] = matrix[i][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + matrix[i][j];
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = i; j < m; j++) {
                int subMatrix = 0;
                HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
                map.put(0, -1);
                for (int k = 0; k < n; k++) {
                    if (i == 0) {
                        subMatrix += dp[j][k];
                    } else {
                        subMatrix += dp[j][k] - dp[i - 1][k];
                    }
                    if (map.containsKey(subMatrix)) {
                        res[0][0] = i;
                        res[0][1] = map.get(subMatrix) + 1;
                        res[1][0] = j;
                        res[1][1] = k;
                    } else {
                        map.put(subMatrix, k);
                    }
                }
            }
        }
        return res;
    }
}