/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param A: an integer array
     * @return: a tree node
     */
    public TreeNode sortedArrayToBST(int[] A) {  
        // write your code here
        if (A == null || A.length == 0) {
            return null;
        }
        return solveUtil(A, 0, A.length - 1);
    }  
    
    public TreeNode solveUtil(int[] A, int lo, int hi) {
        if (lo > hi) {
            return null;
        }
        int mid = (lo + hi) / 2;
        TreeNode root = new TreeNode(A[mid]);
        
        TreeNode left = solveUtil(A, lo, mid - 1);
        TreeNode right = solveUtil(A, mid + 1, hi);
        
        root.left = left;
        root.right = right;
        
        return root;
    }
}

