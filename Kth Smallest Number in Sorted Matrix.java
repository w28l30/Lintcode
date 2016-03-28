public class Solution {
    /**
     * @param matrix: a matrix of integers
     * @param k: an integer
     * @return: the kth smallest number in the matrix
     */
    private static class IntWithIndex implements Comparable<IntWithIndex> {
        private int col;
        private int row;
        private int val;
        
        public IntWithIndex(int row, int col, int val) {
            this.col = col;
            this.row = row;
            this.val = val;
        }
        
        public int compareTo(IntWithIndex other) {
            return this.val - other.val;
        }
    }
    
    public int kthSmallest(int[][] matrix, int k) {
        // write your code here
        if (matrix == null || matrix.length == 0) {
            return - 1;
        }
        int N = matrix.length;
        int M = matrix[0].length;
        PriorityQueue<IntWithIndex> q = new PriorityQueue<IntWithIndex>();
        for (int i = 0; i < N; i++) {
            q.add(new IntWithIndex(i, 0, matrix[i][0]));
        }
        
        int cnt = 0;
        int res = 0;
        while (q.size() != 0) {
            IntWithIndex top = q.poll();
            cnt++;
            if (cnt == k) {
                res = top.val;
                break;
            }
            int curCol = top.col;
            int curRow = top.row;
            if (curCol < M - 1) { 
                q.add(new IntWithIndex(curRow, curCol + 1, matrix[curRow][curCol + 1]));
            }
        }
        return res;
    }
}
