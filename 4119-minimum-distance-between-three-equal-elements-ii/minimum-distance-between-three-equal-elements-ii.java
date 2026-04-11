class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        int ans = Integer.MAX_VALUE;

        for (List<Integer> list : map.values()) {
            if (list.size() < 3) continue;

            for (int i = 0; i <= list.size() - 3; i++) {
                int i1 = list.get(i);
                int i3 = list.get(i + 2);

                int dist = 2 * (i3 - i1);
                ans = Math.min(ans, dist);
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}