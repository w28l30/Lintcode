public class Solution {
    /**
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        // write your code here
        List<List<String>> ans = new ArrayList<List<String>>();
        int length = s.length();
        if (s == null || length == 0) {
            return ans;
        }
        partitionHelper(s, new ArrayList<String>(), ans);
        return ans;
    }
    
    public void partitionHelper(String s, ArrayList<String> res, List<List<String>> ans) {
        for (int i = 1; i <= s.length(); i++) {
            String pre = s.substring(0, i);
            String next = s.substring(i);
            ArrayList<String> copy = new ArrayList<String>(res);
            if (!isPalindrome(pre)) {
                continue;
            }
            copy.add(pre);
            if (i == s.length()) {
                ans.add(copy);
            } else {
                partitionHelper(next, copy, ans);
            }
        }
    }
    
    public boolean isPalindrome(String s) {
        int length = s.length();
        int i = 0;
        int j = length - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
