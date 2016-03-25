public class Solution {
    /**
     * @param A an integer array
     * @return  A list of integers includes the index of the first number and the index of the last number
     */
    public ArrayList<Integer> continuousSubarraySum(int[] A) {
        // Write your code here
        if (A == null || A.length == 0) {
            return null;
        }
        int[] dp = new int[A.length];
        int[] start = new int[A.length];
        
        ArrayList<Integer> subArray = new ArrayList<Integer>();
        for (int i = 0; i < A.length; i++) {
            dp[i] = A[i];
            start[i] = i;
        } 
        
        for (int i = 1; i < A.length; i++) {
            if (dp[i - 1] + A[i] > dp[i]) {
                dp[i] = dp[i - 1] + A[i];
                start[i] = start[i - 1];
            }
        }
        
        int max = dp[0];
        int maxIndex = 0;
        
        for (int i = 1; i < A.length; i++) {
            if (dp[i] > max) {
                max = dp[i];
                maxIndex = i;
            }
        }
        
        subArray.add(start[maxIndex]);
        subArray.add(maxIndex);
        
        return subArray;
    }
}
