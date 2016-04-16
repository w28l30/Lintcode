public class Solution {
    /**    
     * @param A: an array of integers
     * @return: an integer
     */
    public int firstMissingPositive(int[] A) {
        // write your code here
        for (int i = 0; i < A.length;) {
            int index = A[i] - 1;
            if (index >= A.length || index < 0 || A[i] == A[index]) {
                i++;
            } else {
                int temp = A[index];
                A[index] = A[i];
                A[i] = temp;
            }
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] != (i + 1)) {
                return i + 1;
            }
        }
        return A.length + 1;
    }
}