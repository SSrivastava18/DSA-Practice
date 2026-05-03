class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 0;
        Integer currentArrowPosition = null;

        for (int[] balloon : points) {
            if (currentArrowPosition == null || balloon[0] > currentArrowPosition) {
                arrows++;
                currentArrowPosition = balloon[1];
            }
        }

        return arrows;
        
    }
}