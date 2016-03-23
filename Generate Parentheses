public class Solution {
    /**
     * @param n n pairs
     * @return All combinations of well-formed parentheses
     */
  public ArrayList<String> generateParenthesis(int n) {
        // Write your code here
        ArrayList<String> result = new ArrayList<String>();
        char[] parentheses = new char[n * 2];
        parenthesesHelper(n, n, 0, result, parentheses);
        return result;
    }
    
    public void parenthesesHelper(int left, int right, int count, ArrayList<String> result, char[] parentheses) {
        if (left < 0 || left > right) {
        	return;
        }

        if (left == 0 && right == 0) {
            result.add(String.valueOf(parentheses));
            return;
        }
        if (left > 0) {
        	parentheses[count] = '(';
            parenthesesHelper(left - 1, right, count + 1, result, parentheses);
        }
        if (right > left) {
        	parentheses[count] = ')';
            parenthesesHelper(left, right - 1, count + 1, result, parentheses);
        }
    }
}