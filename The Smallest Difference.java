public class Solution {
    /**
     * @param A, B: Two integer arrays.
     * @return: Their smallest difference.
     */
    private static class Wrapper implements Comparable<Wrapper> {
        int value;
        boolean fromA;
        public Wrapper(int value, boolean fromA) {
            this.value = value;
            this.fromA = fromA;
        }
        
        public int compareTo(Wrapper other) {
            return this.value - other.value;
        }
    }
    public int smallestDifference(int[] A, int[] B) {
        // write your code here
        if (A == null || B == null || A.length == 0 || B.length == 0) {
            return 0;
        }
        int aLength = A.length;
        int bLength = B.length;
        Wrapper[] wrapperArr = new Wrapper[aLength + bLength];
        for (int i = 0; i < aLength; i++) {
            wrapperArr[i] = new Wrapper(A[i], true);
        }
        for (int j = aLength; j < wrapperArr.length; j++) {
            wrapperArr[j] = new Wrapper(B[j - aLength], false);
        }
        Arrays.sort(wrapperArr);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < wrapperArr.length; i++) {
            if (wrapperArr[i].fromA == wrapperArr[i - 1].fromA) {
                continue;
            }
            int diff = Math.abs(wrapperArr[i].value - wrapperArr[i - 1].value);
            if (diff < minDiff) {
                minDiff = diff;
            }
        }
        return minDiff;
    }
}



create table department
(
id int primary key,
name varchar(40)
);