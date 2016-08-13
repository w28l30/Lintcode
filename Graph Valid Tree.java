public class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (n <= 0) return false;
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = -1;
        }
        
        for (int i = 0; i < edges.length; i++) {
            
            int x = find(parent, edges[i][0]);
            int y = find(parent, edges[i][1]);
            if (x == y) return false;
            union(parent, x, y);
        }
        int numOfConnected = 0;        
        for (int j = 0; j < n; j++) {
            if (parent[j] == -1) {
                numOfConnected++;
                if (numOfConnected > 1) return false;
            }
        }
        
        return true;
    }
    
    public int find(int[] parent, int i) {
        if (parent[i] == -1) return i;
        return find(parent, parent[i]);
    }
    
    public void union(int[] parent, int x, int y) {
        int xSet = find(parent, x);
        int ySet = find(parent, y);
        parent[xSet] = ySet;
    }
}
