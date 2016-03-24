public class Solution {
    /**
     * @param digits A digital string
     * @return all posible letter combinations
     */
    public ArrayList<String> letterCombinations(String digits) {
        // Write your code here
        ArrayList<String> result = new ArrayList<String>();
        int length = digits.length();
        if (digits == null || length == 0) {
            return result;
        }
        char[][] maps = {{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
        char[][] helper = new char[length][];
        for (int i = 0; i < length; i++) {
            helper[i] = maps[digits.charAt(i) - '2'];
        }
        letterCombinationsHelper(result, "", helper, 0);
        return result;
    }
    
    public void letterCombinationsHelper(ArrayList<String> result, String s, char[][] maps, int cur) {
        if (cur == maps.length) {
            result.add(s);
            return;
        }
        for (int i = 0; i < maps[cur].length; i++) {
            StringBuilder sb = new StringBuilder(s);
            sb.append(maps[cur][i]);
            letterCombinationsHelper(result, sb.toString(), maps, cur + 1);
        }
    }
}
