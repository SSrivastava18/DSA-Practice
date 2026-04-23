class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] arr = new long[n];

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }

        for (List<Integer> indices : map.values()) {
            int size = indices.size();

            long[] prefix = new long[size];
            prefix[0] = indices.get(0);

            for (int i = 1; i < size; i++) {
                prefix[i] = prefix[i - 1] + indices.get(i);
            }

            for (int k = 0; k < size; k++) {
                int idx = indices.get(k);

                long left = 0;
                if (k > 0) {
                    left = (long) k * idx - prefix[k - 1];
                }

                long right = 0;
                if (k < size - 1) {
                    right = (prefix[size - 1] - prefix[k])
                            - (long)(size - k - 1) * idx;
                }

                arr[idx] = left + right;
            }
        }

        return arr;
    }
}