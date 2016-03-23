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
     * @param root the root of the binary tree
     * @return all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        // Write your code here
        ArrayList<String> result = new ArrayList<String>();
        binaryTreePathsUtil(root, "", result);
        return result;
    }
    
    public void binaryTreePathsUtil(TreeNode root, String s, ArrayList<String> result) {
        if (root == null) {
            return;
        }
        StringBuilder sb = new StringBuilder(s);
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            result.add(sb.toString());
        }  else  {
            sb.append("->");
            binaryTreePathsUtil(root.right, sb.toString(), result);
            binaryTreePathsUtil(root.left, sb.toString(), result);
        }
    }
    
}
