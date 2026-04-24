class Solution {

    class Pair {
        int node;
        int time;

        Pair(int node, int time) {
            this.node = node;
            this.time = time;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {

        // Step 1: Build graph
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] t : times) {
            int u = t[0];
            int v = t[1];
            int w = t[2];

            graph.get(u).add(new Pair(v, w));
        }

        // Step 2: Distance array
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        // Step 3: Min Heap
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.time - b.time);
        pq.add(new Pair(k, 0));

        // Step 4: Dijkstra
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int node = curr.node;
            int time = curr.time;

            // Optimization (skip outdated entries)
            if (time > dist[node]) continue;

            for (Pair nei : graph.get(node)) {
                int next = nei.node;
                int wt = nei.time;

                if (time + wt < dist[next]) {
                    dist[next] = time + wt;
                    pq.add(new Pair(next, dist[next]));
                }
            }
        }

        // Step 5: Find max time
        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            maxTime = Math.max(maxTime, dist[i]);
        }

        return maxTime;
    }
}