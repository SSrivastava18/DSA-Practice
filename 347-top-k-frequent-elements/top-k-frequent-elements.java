class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(num);
        }

        List<Integer> topk = new ArrayList<>();
        for (int i = bucket.length - 1; i >= 0 && topk.size() < k; i--) {
            if (bucket[i] != null) {
                topk.addAll(bucket[i]);
            }
        }

        return topk.stream().mapToInt(i -> i).toArray();
    }
}