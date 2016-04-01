public class Solution {
    /**
     * @param ratings Children's ratings
     * @return the minimum candies you must give
     */
    public int candy(int[] ratings) {
        // Write your code here
        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        if (ratings.length == 1) {
            return 1;
        }
        int[] dp = new int[ratings.length];
        dp[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                dp[i] = dp[i- 1] + 1; 
            } else {
                dp[i] = 1;
            }
        }
        for (int j = ratings.length - 1; j >= 1; j--) {
            if (ratings[j] < ratings[j - 1]) {
            	if (dp[j] >= dp[j - 1]) {
            		dp[j - 1] = dp[j] + 1;
            	}
            }
        }
        int sum = 0;
        for (int i = 0; i < ratings.length; i++) {
            sum += dp[i];
        }
        return sum;
    }
}