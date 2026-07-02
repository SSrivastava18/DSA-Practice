class Solution {
    static int[] parent;
    static int[] rank;
    static int components;

    public static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    public static boolean union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px == py) return false; 

        if (rank[px] < rank[py]) {
            parent[px] = py;
        } else if (rank[px] > rank[py]) {
            parent[py] = px;
        } else {
            parent[py] = px;
            rank[px]++;
        }

        components--; 
        return true;
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        parent = new int[n];
        rank = new int[n];
        components = n;

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        for (int i = 0; i < n; i++) { 
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    union(i, j);
                }
            }
        }

        return components;
    }
}
