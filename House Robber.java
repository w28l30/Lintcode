public class Solution {
    /**
     * @param A: An array of non-negative integers.
     * return: The maximum amount of money you can rob tonight
     */
    public long houseRobber(int[] A) {
        // write your code here
        int length = A.length;
        long[] dp = new long[length];
        if (length == 0 || A == null) {
            return 0;
        }
        if (length == 1) {
            return A[0];
        }
        dp[0] = A[0];
        dp[1] = A[1] > dp[0] ? A[1] : dp[0];
        
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 1], A[i] + dp[i - 2]);
        }
        return dp[length - 1] > dp[length - 2] ? dp[length - 1] : dp[length - 2];
    }
}