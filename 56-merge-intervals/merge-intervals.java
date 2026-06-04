class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<List<Integer>> merged = new ArrayList<>();

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i][0] <= end) {
                end = Math.max(end, intervals[i][1]);
            } else {
                List<Integer> curr = new ArrayList<>();
                curr.add(start);
                curr.add(end);
                merged.add(curr);

                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        List<Integer> curr = new ArrayList<>();
        curr.add(start);
        curr.add(end);
        merged.add(curr);

        int[][] ans = new int[merged.size()][2];

        for (int i = 0; i < merged.size(); i++) {
            ans[i][0] = merged.get(i).get(0);
            ans[i][1] = merged.get(i).get(1);
        }

        return ans;
    }
}