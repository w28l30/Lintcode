public class Solution {
    /**
     * @param A an array of Integer
     * @return  an integer
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
        // Write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        int maxCountIncrease = 0;
        int maxCountDecrease = 0;
        int count = 1;
        
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                count++;
            } else {
                if (count > maxCountIncrease) {
                    maxCountIncrease = count;
                }
                count = 1;
            }
        }
        if (count > maxCountIncrease) {
            maxCountIncrease = count;
        }
        
        count = 1;
        
        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[i - 1]) {
                count++;
            } else {
                if (count > maxCountDecrease) {
                    maxCountDecrease = count;
                }
                count = 1;
            }
        }
        
        if (count > maxCountDecrease) {
            maxCountDecrease = count;
        }
        
        return Math.max(maxCountIncrease, maxCountDecrease);
    }
}
