class Solution {

    class Pair {
        int node;
        int cost;
        int stops;

        Pair(int node, int cost, int stops) {
            this.node = node;
            this.cost = cost;
            this.stops = stops;
        }
    }

    public int findCheapestPrice(int n, int[][] flights,
                                 int src, int dst, int k) {

        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] flight : flights) {

            int u = flight[0];
            int v = flight[1];
            int price = flight[2];

            graph.get(u).add(new Pair(v, price, 0));
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(src, 0, 0));
        dist[src] = 0;

        while (!q.isEmpty()) {

            Pair curr = q.poll();

            int node = curr.node;
            int cost = curr.cost;
            int stops = curr.stops;

            if (stops > k) {
                continue;
            }

            for (Pair p : graph.get(node)) {

                int adjNode = p.node;
                int edgeCost = p.cost;

                if (cost + edgeCost < dist[adjNode]) {

                    dist[adjNode] = cost + edgeCost;

                    q.offer(
                        new Pair(
                            adjNode,
                            dist[adjNode],
                            stops + 1
                        )
                    );
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE
                ? -1
                : dist[dst];
    }
}