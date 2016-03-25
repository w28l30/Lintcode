/**
 * public class NBCompare {
 *     public int cmp(String a, String b);
 * }
 * You can use compare.cmp(a, b) to compare nuts "a" and bolts "b",
 * if "a" is bigger than "b", it will return 1, else if they are equal,
 * it will return 0, else if "a" is smaller than "b", it will return -1.
 * When "a" is not a nut or "b" is not a bolt, it will return 2, which is not valid.
*/
public class Solution {
    /**
     * @param nuts: an array of integers
     * @param bolts: an array of integers
     * @param compare: a instance of Comparator
     * @return: nothing
     */
    public void sortNutsAndBolts(String[] nuts, String[] bolts, NBComparator compare) {
        // write your code here
        if (nuts == null || nuts.length == 0 ||  bolts == null || bolts.length == 0) {
            return;
        }
        qSort(nuts, bolts, 0, nuts.length - 1, compare);
    }
    
    public void qSort(String[] nuts, String[] bolts, int i, int j, NBComparator compare) {
        if (i < j) {
            int pivot = partition(nuts, bolts[j], i, j, compare);
            partition(bolts, nuts[pivot], i, j, compare);
            qSort(nuts, bolts, i, pivot -1, compare);
            qSort(nuts, bolts, pivot + 1, j, compare);
        }
    }
    
    public int partition(String[] str, String flag, int low, int high, NBComparator compare) {
        int i = low;
        for (int j = low; j < high; j++) {
            if (compare.cmp(str[j], flag) < 0) {
                swap(str, i, j);
                i++;
            } else if (compare.cmp(str[j], flag) == 0) {
                swap(str, j, high);
                j--;
            }
        }
        swap(str, i, high);
        return i;
    }
    
    public void swap(String[] str, int i, int j) {
        String temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
};