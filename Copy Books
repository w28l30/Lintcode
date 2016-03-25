public class Solution {
    /**
     * @param pages: an array of integers
     * @param k: an integer
     * @return: an integer
     */
    public int copyBooks(int[] pages, int k) {
        // write your code here
        int[][] dp = new int[k + 1][pages.length + 1];
        int max = 0;
        int sum = 0;
        for (int i = 1; i <= pages.length; i++) {
            max = Math.max(max, pages[i - 1]);
            sum += pages[i - 1];
            dp[1][i] = sum;
        }
        if (k >= pages.length) {
            return max;
        }
        
        for (int i = 2; i <= k; i++) {
            for (int j = i - 1; j < pages.length; j++) {
                int min = Math.max(dp[i - 1][j], pages[j]);
                dp[i][j + 1] = min;
                int current = pages[j];
                for (int l = j - 1; l >= i - 1; l--) {
                    current += pages[l];
                    int curMin = Math.max(current, dp[i - 1][l]);
                    if (curMin < min) {
                        min = curMin;
                        dp[i][j + 1] = min;
                    }
                }
            }
        }
        
        return dp[k][pages.length];
    }
}
