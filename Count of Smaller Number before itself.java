public class Solution {
   /**
     * @param A: An integer array
     * @return: Count the number of element before this element 'ai' is 
     *          smaller than it and return count number array
     */ 
    public ArrayList<Integer> countOfSmallerNumberII(int[] A) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        SegmentTreeNode root = build(0, 10000);
        for (int j = 0; j < A.length; j++) {
            res.add(SegmentTreeQuery(root, 0, A[j] - 1));
            SegmentTreeNodemodify(root, A[j], 1);
        }
        return res;
    }
    
        public int SegmentTreeQuery(SegmentTreeNode root, int start, int end) {
            if (root == null) {
                return 0;
            }
            if (root.start == start && root.end == end) {
                return root.count;
            }
            int leftCount = 0;
            int rightCount = 0;
            int mid = (root.start + root.end) / 2;
            if (start <= mid) {
                if (end > mid) {
                    leftCount = SegmentTreeQuery(root.left, start, mid);
                } else {
                    leftCount = SegmentTreeQuery(root.left, start, end);
                }
            }
            if (mid < end) {
                if (start > mid) {
                    rightCount = SegmentTreeQuery(root.right, start, end);
                } else {
                    rightCount = SegmentTreeQuery(root.right, mid + 1, end);
                }
            }
            return leftCount + rightCount;
        }
    
        class SegmentTreeNode {
            public int start, end;
            public int count;
            public SegmentTreeNode left, right;
            public SegmentTreeNode(int start, int end, int count) {
                this.start = start;
                this.end = end;
                this.left = null;
                this.right = null;
                this.count = count;
            }
        }
        
        public SegmentTreeNode build(int start, int end) {
            if (start > end) {
                return null;
            }
            int mid = start + (end - start) / 2;
            SegmentTreeNode root = new SegmentTreeNode(start, end, 0);
            if (start != end) {
                root.left = build(start, mid);
                root.right = build(mid + 1, end);
            }
            return root;
        }
        
        public void SegmentTreeNodemodify(SegmentTreeNode root, int index, int value) {
            if (root.start == index && root.end == index) {
                root.count += value;
                return;
            }
            int mid = (root.start + root.end) / 2;
            if (index >= root.start && index <= mid) {
                SegmentTreeNodemodify(root.left, index, value);
            }
            if (index > mid && index <= root.end) {
                SegmentTreeNodemodify(root.right, index, value);
            }
            root.count = root.left.count + root.right.count;
        }
}
