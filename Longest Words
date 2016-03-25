class Solution {
    /**
     * @param dictionary: an array of strings
     * @return: an arraylist of strings
     */
    ArrayList<String> longestWords(String[] dictionary) {
        // write your code here
        if (dictionary == null) {
            return null;
        }
        
        ArrayList<String> longestWords = new ArrayList<String>();
        int maxLength = 0;
        
        for (int i = 0; i < dictionary.length; i++) {
            if (dictionary[i].length() > maxLength) {
                maxLength = dictionary[i].length();
                longestWords.clear();
                longestWords.add(dictionary[i]);
            } else if (dictionary[i].length() == maxLength) {
                longestWords.add(dictionary[i]);
            }
        }
        
        return longestWords;
    }
};
