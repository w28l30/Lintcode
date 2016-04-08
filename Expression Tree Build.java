/**
 * Definition of ExpressionTreeNode:
 * public class ExpressionTreeNode {
 *     public String symbol;
 *     public ExpressionTreeNode left, right;
 *     public ExpressionTreeNode(String symbol) {
 *         this.symbol = symbol;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param expression: A string array
     * @return: The root of expression tree
     */
    class TreeNode {
        public int val;
        public ExpressionTreeNode root;
        public TreeNode (int val, String str) {
            this.val = val;
            this.root = new ExpressionTreeNode(str);
        }
    }
    
    public int get(String a, int base) {
        if (a.equals("+") || a.equals("-")) {
            return base + 1;
        } else if (a.equals("*") || a.equals("/")) {
            return base + 2;
        }
        return Integer.MAX_VALUE;
    }
    
    public ExpressionTreeNode build(String[] expression) {
		// write your code here
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode root = null;
		int val = 0;
		int base = 0;
		for (int i = 0; i <= expression.length; i++) {
			if(i != expression.length)
			{
				
				if (expression[i].equals("(")) {
					base += 10;
					continue;
				}
				if (expression[i].equals(")")) {
					base -= 10;
					continue;
				}
				val = get(expression[i], base);

			}
			TreeNode right = i == expression.length ? new TreeNode(
					Integer.MIN_VALUE, "") : new TreeNode(val,
					expression[i]);
			while (!stack.isEmpty()) {
				if (right.val <= stack.peek().val) {
					TreeNode nodeNow = stack.pop();

					if (stack.isEmpty()) {
						right.root.left = nodeNow.root;

					} else {
						TreeNode left = stack.peek();
						if (left.val < right.val) {
							right.root.left = nodeNow.root;
						} else {
							left.root.right = nodeNow.root;
						}
					}
				} else {
					break;
				}
			}
			stack.push(right);
		}

		return stack.peek().root.left;
	}
}