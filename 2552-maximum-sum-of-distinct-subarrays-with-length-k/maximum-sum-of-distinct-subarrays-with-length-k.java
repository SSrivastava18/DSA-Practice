class Solution {
    public long maximumSubarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        long sum = 0;
        long maxSum = 0;

        for (int i = 0; i < k; i++) {
            sum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        if (map.size() == k) {
            maxSum = sum;
        }

        for (int i = k; i < nums.length; i++) {

            int left = nums[i - k];
            map.put(left, map.get(left) - 1);
            if (map.get(left) == 0) {
                map.remove(left);
            }

            sum -= left;

            int right = nums[i];
            map.put(right, map.getOrDefault(right, 0) + 1);
            sum += right;

            if (map.size() == k) {
                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }
}