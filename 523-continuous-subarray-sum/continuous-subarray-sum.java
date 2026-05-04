import java.util.HashMap;

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int prefixSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); 

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            int rem = k == 0 ? prefixSum : prefixSum % k;

            if (map.containsKey(rem)) {
                int prevIndex = map.get(rem);
                if (i - prevIndex >= 2) {
                    return true;
                }
            } else {
                map.put(rem, i);
            }
        }

        return false;
    }
}