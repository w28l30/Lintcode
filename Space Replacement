public class Solution {
    /**
     * @param string: An array of Char
     * @param length: The true length of the string
     * @return: The true length of new string
     */
    public int replaceBlank(char[] string, int length) {
        // Write your code here
        int countSpace = 0;
        for (int i = 0; i < length; i++) {
            if (string[i] == ' ') {
                countSpace++;
            }
        }
        
        int j = length + 2*countSpace - 1;
        int k = length - 1;
        while (j >= 0 && k >= 0) {
            if (string[k] == ' ') {
                string[j--] = '0';
                string[j--] = '2';
                string[j--] = '%';
                --k;
            } else {
                string[j--] = string[k--];
            }
        }
        return length + 2*countSpace;
    }
}
 