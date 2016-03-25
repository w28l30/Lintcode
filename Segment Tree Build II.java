/**
 * Definition of SegmentTreeNode:
 * public class SegmentTreeNode {
 *     public int start, end, max;
 *     public SegmentTreeNode left, right;
 *     public SegmentTreeNode(int start, int end, int max) {
 *         this.start = start;
 *         this.end = end;
 *         this.max = max
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     *@param A: a list of integer
     *@return: The root of Segment Tree
     */
    public SegmentTreeNode build(int[] A) {
        // write your code here
        int size = A.length;
        if (A == null || size == 0) {
            return null;
        }
        int start = 0;
        int end = size - 1;
        SegmentTreeNode root = new SegmentTreeNode(start, end, findMax(A, start, end));
        buildHelper(root, A);
        return root;
    }
    
    public void buildHelper(SegmentTreeNode root, int[] A) {
        if (root.start == root.end) {
            return;
        }
        int leftStart = root.start;
        int leftEnd = (root.start + root.end) / 2;
        int rightStart = (root.start + root.end) / 2 + 1;
        int rightEnd = root.end;
        root.left = new SegmentTreeNode(leftStart, leftEnd, findMax(A, leftStart, leftEnd));
        root.right = new SegmentTreeNode(rightStart, rightEnd, findMax(A, rightStart, rightEnd));
        buildHelper(root.left, A);
        buildHelper(root.right, A);
    }
    
    public int findMax(int[] A, int start, int end) {
        if (start == end) {
            return A[start];
        }
        int max = A[start];
        for (int i = start + 1; i <= end; i++) {
            if (A[i] > max) {
                max = A[i];
            }
        }
        return max;
    }
}
