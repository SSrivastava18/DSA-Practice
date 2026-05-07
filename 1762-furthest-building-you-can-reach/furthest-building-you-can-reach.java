class Solution {

    public int furthestBuilding(int[] heights, int bricks, int ladders) {

        PriorityQueue<Integer> pq =
            new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < heights.length - 1; i++) {

            int diff = heights[i + 1] - heights[i];

            if (diff <= 0) {
                continue;
            }

            pq.offer(diff);

            bricks -= diff;

            // if bricks become insufficient
            if (bricks < 0) {

                if (ladders > 0) {

                    bricks += pq.poll();
                    ladders--;

                } else {
                    return i;
                }
            }
        }

        return heights.length - 1;
    }
}