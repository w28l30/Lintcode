class Solution {
    /**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: Cosine similarity.
     */
    public double cosineSimilarity(int[] A, int[] B) {
        // write your code here
        if (isInvalid(A) || isInvalid(B)) {
            return 2.0000;
        }
        double numerator = 0.0;
        double denominator = 0.0;
        double aSqureSum = 0.0;
        double bSqureSum = 0.0;
        for (int i = 0; i < A.length; i++) {
            numerator += A[i] * B[i];
            aSqureSum += A[i] * A[i];
            bSqureSum += B[i] * B[i];
        }
        denominator = Math.sqrt(aSqureSum) * Math.sqrt(bSqureSum);
        return numerator / denominator;
    }
    
    public boolean isInvalid(int[] A) {
        int i = 0;
        while (i < A.length) {
            if (A[i] == 0) {
                i++;
            } else {
                return false;
            }
        }
        return true;
    }
}

