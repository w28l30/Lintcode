/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

class Solution {
    /**
     * @param intervals: An interval array
     * @return: Count of airplanes are in the sky.
     */
    public int countOfAirplanes(List<Interval> airplanes) { 
        // write your code here
        ArrayList<PairHelper> list = new ArrayList<PairHelper>();
        for (Interval i : airplanes) {
            PairHelper start = new PairHelper(i.start, true);
            PairHelper end = new PairHelper(i.end, false);
            list.add(start);
            list.add(end);
        }
        Collections.sort(list, new PairHelperComparator());
        int res = 0;
        int cnt = 0;
        for (PairHelper j : list) {
            if (j.isStart == true) {
                cnt++;
            } else {
                cnt--;
            }
            res = Math.max(res, cnt);
        }
        return res;
    }
    
    private static class PairHelper {
        int num;
        boolean isStart;
        
        public PairHelper(int a, boolean b) {
            this.num = a;
            this.isStart = b;
        }
    }
    
    class PairHelperComparator implements Comparator<PairHelper> {
        public int compare(PairHelper a , PairHelper b) {
            if (a.num == b.num) {
                if (!a.isStart) {
                    return -1;
                } else {
                    return 1;
                }
            } else {
                return a.num - b.num;
            }
        }
    }
}