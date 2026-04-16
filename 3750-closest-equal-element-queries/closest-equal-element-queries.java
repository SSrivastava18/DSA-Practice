class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }

        List<Integer> ans = new ArrayList<>();

        for (int q : queries) {
            int val = nums[q];
            List<Integer> list = map.get(val);

            if (list.size() == 1) {
                ans.add(-1);
                continue;
            }

            int idx = Collections.binarySearch(list, q);

            int prev = (idx - 1 + list.size()) % list.size();
            int next = (idx + 1) % list.size();

            int prevIndex = list.get(prev);
            int nextIndex = list.get(next);

            int d1 = Math.abs(q - prevIndex);
            d1 = Math.min(d1, n - d1);

            int d2 = Math.abs(q - nextIndex);
            d2 = Math.min(d2, n - d2);

            ans.add(Math.min(d1, d2));
        }

        return ans;
    }
}