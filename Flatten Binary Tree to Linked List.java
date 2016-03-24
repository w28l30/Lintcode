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
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    TreeNode dummyNode = new TreeNode(0);
    TreeNode prev = dummyNode;
    public void flatten(TreeNode root) {
        // write your code here
        if (root == null) {
            return;
        }
        while (root != null) {
            if (root.left !=null) {
                max(root.left).right = root.right;
                
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }
    
    public TreeNode max(TreeNode root) {
        if (root.right == null) {
            return root;
        }
        return max(root.right);
    }
}
