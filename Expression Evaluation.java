public class Solution {
    /**
     * @param expression: an array of strings;
     * @return: an integer
     */
    public class ExpressionTreeNode {
        public String symbol;
        public ExpressionTreeNode left, right;

        public ExpressionTreeNode(String symbol) {
            this.symbol = symbol;
            this.left = this.right = null;
        }
    }
    
    public class TreeNode {
        public int val;
        public ExpressionTreeNode root;

        public TreeNode(int val, String str) {
            this.val = val;
            this.root = new ExpressionTreeNode(str);
        }
    }
    
    public int evaluateExpression(String[] expression) {
        // write your code here
        if (expression == null || expression.length == 0) {
            return 0;
        }
        ArrayList<String> rpnList = convertToRPN(expression);
        String[] tokens = rpnList.toArray(new String[rpnList.size()]);
        return evalRPN(tokens);
    }
    
    public int evalRPN(String[] tokens) {
        // Write your code here
        Stack<Integer> stack = new Stack<Integer>();
        int ans = 0;
        int size = tokens.length;
        if (size == 1) {
            return Integer.parseInt(tokens[0]);
        }
        for (int i = 0; i < size; i++) {
            String s = tokens[i];
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                int res = evalRPNHelper(s.charAt(0), stack);
                if (i == (size - 1)) {
                    ans = res;
                }
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return ans;
    }
    
    public int evalRPNHelper(char operator, Stack<Integer> stack) {
        int b = stack.pop();
        int a = stack.pop();
        int res = 0;
        
        switch (operator) {
            case '+':
                res = a + b;
                break;
            case '-':
                res = a - b;
                break;
            case '*':
                res = a * b;
                break;
            case '/':
                res = a / b;
                break;
            default:
                res = 0;
                break;
        }
        stack.push(res);
        return res;
    }
    
    public ArrayList<String> convertToRPN(String[] expression) {
        ArrayList<String> res = new ArrayList<String>();
        if (expression == null || expression.length == 0) {
            return res;
        }
        ExpressionTreeNode root = build(expression);
        postOrderTraversal(root, res);
        return res;
    }
    
    public void postOrderTraversal(ExpressionTreeNode root, ArrayList<String> res) {
        if (root == null) {
            return;
        }
        postOrderTraversal(root.left, res);
        postOrderTraversal(root.right, res);
        res.add(root.symbol);
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