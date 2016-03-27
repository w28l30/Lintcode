public class Solution {
    /**
     * @param tokens The Reverse Polish Notation
     * @return the value
     */
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
}