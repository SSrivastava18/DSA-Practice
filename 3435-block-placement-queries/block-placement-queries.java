class Solution {

    static class SegmentTree {
        int n;
        int[] tree;

        SegmentTree(int n) {
            this.n = n;
            tree = new int[4 * n];
        }

        void update(int idx, int val) {
            update(1, 0, n - 1, idx, val);
        }

        private void update(int node, int l, int r, int idx, int val) {
            if (l == r) {
                tree[node] = val;
                return;
            }

            int mid = (l + r) / 2;

            if (idx <= mid) {
                update(node * 2, l, mid, idx, val);
            } else {
                update(node * 2 + 1, mid + 1, r, idx, val);
            }

            tree[node] = Math.max(tree[node * 2], tree[node * 2 + 1]);
        }

        int query(int left, int right) {
            return query(1, 0, n - 1, left, right);
        }

        private int query(int node, int l, int r, int left, int right) {
            if (r < left || l > right) {
                return 0;
            }

            if (left <= l && r <= right) {
                return tree[node];
            }

            int mid = (l + r) / 2;

            return Math.max(
                query(node * 2, l, mid, left, right),
                query(node * 2 + 1, mid + 1, r, left, right)
            );
        }
    }

    public List<Boolean> getResults(int[][] queries) {

        int LIMIT = 50001; 

        TreeSet<Integer> obstacles = new TreeSet<>();
        obstacles.add(0);
        obstacles.add(LIMIT);

        SegmentTree seg = new SegmentTree(LIMIT + 1);

        seg.update(LIMIT, LIMIT);

        List<Boolean> ans = new ArrayList<>();

        for (int[] q : queries) {

            if (q[0] == 1) {
                int x = q[1];

                int prev = obstacles.lower(x);
                int next = obstacles.higher(x);

                seg.update(x, x - prev);

                seg.update(next, next - x);

                obstacles.add(x);

            } else {
                int x = q[1];
                int sz = q[2];

                int p = obstacles.floor(x);

                int bestGap = seg.query(0, p);
                int tailGap = x - p;

                ans.add(Math.max(bestGap, tailGap) >= sz);
            }
        }

        return ans;
    }
}