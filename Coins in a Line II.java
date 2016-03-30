public class Solution {
    /**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        // write your code here
        int size = values.length;
        if (size <= 2) {
            return true;
        }
        int[] dp = new int[size];
        dp[size - 1] = values[size - 1];
        dp[size - 2] = values[size - 1] + values[size - 2];
        for (int i = size - 3; i >= 0; i--) {
            dp[i] = Math.max(values[i] - dp[i + 1], values[i] + values[i + 1] - dp[i + 2]);
        }
        if (dp[0] > 0) {
            return true;
        }
        return false;
        
    }
}