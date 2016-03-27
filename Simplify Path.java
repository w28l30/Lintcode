public class Solution {
    /**
     * @param path the original path
     * @return the simplified path
     */
    public String simplifyPath(String path) {
        // Write your code here
        if (path == null || path.length() == 0) {
            return "";
        }
        Stack<String> stack = new Stack<String>();
        int i = 0;
        while (i < path.length()) {
            while (i < path.length() && path.charAt(i) == '/') {
                i++;
            }
               if (i == path.length()) {
                break;
            }
            int start = i;
            while (i < path.length() && path.charAt(i) != '/') {
                i++;
            }
            int end = i;
            String element = path.substring(start, end);
            if (element.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!element.equals(".")) {
                stack.push(element);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            String cur = stack.pop();
            sb.insert(0, cur);
            sb.insert(0, "/");
        }
        return sb.toString();
    }
}