class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;

        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        int count = n / 3 + 1;

        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }

            if (map.get(nums[i]) == count) {
                list.add(nums[i]);
            }

            if (list.size() == 2)
                break;
        }

        return list;
    }
}